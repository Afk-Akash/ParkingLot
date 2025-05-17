package org.parkingLot.parkingCore

import org.parkingLot.models.payment.PaymentHandler
import org.parkingLot.models.payment.PaymentService
import org.parkingLot.models.ticket.TicketsInventory
import org.parkingLot.models.ticket.ParkingTicket
import org.parkingLot.models.vehicle.Vehicle
import java.time.LocalDateTime
import java.time.temporal.ChronoUnit
import java.util.UUID

class CoreParkingSystem(
    private val parkingFloors: List<ParkingFloor>,
    private val paymentHandler: PaymentHandler,
    val name: String
) {
    fun parkVehicle(vehicle: Vehicle): ParkingTicket? {
        parkingFloors.forEachIndexed { index, parkingFloor ->
            val availableParkingSpot = parkingFloor.freeSpot(vehicle.vehicleType)

            if(availableParkingSpot != null){
                val currDateTime = LocalDateTime.now().truncatedTo(ChronoUnit.MINUTES)
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
                TicketsInventory.activeTicket.add(issueTicket)
                println("CoreParkingSystem: Vehicle ${vehicle.vrn} is parked successfully" +
                        " at floor ${parkingFloor.floorNumber} and spot no: ${availableParkingSpot.spotNumber}")
                return issueTicket
            }
        }
        println("Parking Lot is full for vehicle type: ${vehicle.vehicleType}, can't park it")
        return null
    }

    private fun unParkVehicle(ticket: ParkingTicket): Boolean {
        val parkingFloorNo = ticket.parkingFloorNo

        val parkingFloor = parkingFloors[parkingFloorNo-1]

        val paymentConfirmation = paymentHandler.process(ticket)
        if(!paymentConfirmation){
            println("CoreParkingSystem: Payment failed could not un park the vehicle")
            return false
        }

        parkingFloor.vacateSpot(ticket.parkingSpotNo)

        TicketsInventory.activeTicket.remove(ticket)
        ticket.isActive = false
        TicketsInventory.inActiveTicket.add(ticket)
        println("CoreParkingSystem: Vehicle with VRN ${ticket.vehicle.vrn} left the parking " +
                "lot at ${LocalDateTime.now().truncatedTo(ChronoUnit.MINUTES)}")
        return true
    }

    fun unParkVehicle(vrn: String): Boolean {
        println("CoreParkingSystem: starting un-parking process for vrn $vrn")

        val parkingTicket = getTicketUsingVehicle(vrn)
        if(parkingTicket == null){
            println("CoreParkingSystem: This vehicle is not parked in the system or it has been un-parked")
            return false
        }
        return unParkVehicle(parkingTicket)
    }

    private fun getTicketUsingVehicle(vrn: String): ParkingTicket? {
        TicketsInventory.activeTicket.forEach { parkingTicket ->
            if(parkingTicket.vehicle.vrn == vrn && parkingTicket.isActive){
                return parkingTicket
            }
        }
        return null
    }
}