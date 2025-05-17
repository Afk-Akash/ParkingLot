package org.parkingLot

import org.parkingLot.models.ticket.TicketsInventory
import org.parkingLot.models.vehicle.VehicleFactory
import org.parkingLot.parkingCore.CoreParkingSystem
import org.parkingLot.parkingCore.ParkingFloor

fun main() {
    val factory = VehicleFactory()

    val carA = factory.getVehicle("Car", "BR00AA0000")
    val bikeB = factory.getVehicle("Bike", "UP12AC9898")
    val carC = factory.getVehicle("Car", "TN00AA0000")


    val floor1 = ParkingFloor(floorNumber = 1, bikeParkingSpot = 2, carParkingSpot = 2)
    val floor2 = ParkingFloor(floorNumber = 2, bikeParkingSpot = 1, carParkingSpot = 3)

    val parkingSystem = CoreParkingSystem(
        parkingFloors = listOf(floor1, floor2),
        name = "Downtown Multi-Floor Lot"
    )

    val ticketA = parkingSystem.parkVehicle(carA)
    val ticketB = parkingSystem.parkVehicle(bikeB)
    val ticketC = parkingSystem.parkVehicle(carC)

    println("Active tickets:")
    TicketsInventory.activeTicket.forEach { println(it) }

    parkingSystem.unParkVehicle(ticketC)


//    println("\nUn-parking all vehicles:")
//    ActiveTickets.activeTicket.toList().forEach { ticket ->
//    }

    println("\nAfter un-parking, active tickets:")
    println(TicketsInventory.activeTicket)

}