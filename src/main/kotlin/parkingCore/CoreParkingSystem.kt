package org.parkingLot.parkingCore

import org.parkingLot.models.ticket.ActiveTickets
import org.parkingLot.models.ticket.ParkingTicket
import org.parkingLot.models.vehicle.Vehicle
import java.time.LocalDateTime
import java.util.UUID

class CoreParkingSystem(
    private val parkingFloors: List<ParkingFloor>,
    val name: String
) {
    fun parkVehicle(vehicle: Vehicle): Boolean {
        parkingFloors.forEachIndexed { index, parkingFloor ->
            val availableParkingSpot = parkingFloor.freeSpot(vehicle.vehicleType)

            if(availableParkingSpot != null){
                val currDateTime = LocalDateTime.now()
                val ticketId = UUID.randomUUID().toString()
                val issueTicket = ParkingTicket(
                    ticketId = ticketId,
                    vehicle = vehicle,
                    issuedTime = currDateTime,
                    parkingFloorNo = index+1,
                    parkingSpotNo = availableParkingSpot.spotNumber,
                    isActive = true
                )
                availableParkingSpot.assignVehicle(vehicle)
                ActiveTickets.activeTicket.plus(issueTicket)
                println("CoreParkingSystem: Vehicle ${vehicle.vrn} is parked successfully at floor $parkingFloor " +
                        "and spot no: ${availableParkingSpot.spotNumber}")
                return true
            }
        }
        println("Parking Lot is full for vehicle type: ${vehicle.vehicleType}")
        return false
    }

    fun unParkVehicle(ticket: ParkingTicket): Boolean {
        val parkingFloorNo = ticket.parkingFloorNo
        val parkingSpotNo = ticket.parkingSpotNo

        val parkingFloor = parkingFloors[parkingFloorNo-1]

        val parkingSpot = parkingFloor.getSpotById(parkingSpotNo)

        parkingSpot?.vacateSpot()
        println("CoreParkingSystem: Vehicle with VRN ${ticket.vehicle.vrn} left the parking lot at ${LocalDateTime.now()}")
        return true
    }

    fun unParkVehicle(vehicle: Vehicle): Boolean {
        println("CoreParkingSystem: user has lost the ticket so searching vehicle with vehicle vrn ${vehicle.vrn} and " +
                "type ${vehicle.vehicleType}")

        val parkingTicket = getTicketUsingVehicle(vehicle)
        if(parkingTicket == null){
            println("CoreParkingSystem: didn't get active ticket with given vehicle details")
            throw RuntimeException("This vehicle is not parked in the system or it has been un-parked")
        }
        return unParkVehicle(parkingTicket)
    }

    private fun getTicketUsingVehicle(vehicle: Vehicle): ParkingTicket? {
        ActiveTickets.activeTicket.forEach { parkingTicket ->
            if(parkingTicket.vehicle == vehicle && parkingTicket.isActive){
                return parkingTicket
            }
        }
        return null
    }
}