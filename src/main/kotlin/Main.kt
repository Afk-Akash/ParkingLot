package org.parkingLot

import org.parkingLot.models.utils.FeeCalculator
import org.parkingLot.models.factory.PaymentFactory
import org.parkingLot.models.payment.PaymentHandler
import org.parkingLot.models.payment.PaymentUserInput
import org.parkingLot.models.factory.VehicleFactory
import org.parkingLot.parkingCore.CoreParkingSystem
import org.parkingLot.parkingCore.ParkingFloor

fun main() {
    val vehicleFactory = VehicleFactory()


    val floor1 = ParkingFloor(floorNumber = 1, bikeParkingSpot = 1, carParkingSpot = 2)
    val floor2 = ParkingFloor(floorNumber = 2, bikeParkingSpot = 1, carParkingSpot = 3)

    val feeCalculator    = FeeCalculator()
    val userInput        = PaymentUserInput()
    val paymentFactory   = PaymentFactory()
    val paymentHandler   = PaymentHandler(feeCalculator, userInput, paymentFactory)

    val parkingSystem = CoreParkingSystem(
        parkingFloors = listOf(floor1, floor2),
        paymentHandler = paymentHandler,
        name = "Downtown Multi-Floor Lot"
    )
    println("-------WELCOME TO DOWNTOWN PARKING LOT-------")
    println("   -------------------------------------")
    println("       ----------------------------   ")
    println("           ------------------       ")
    println("                ---------        ")
    val system = true

    while(system){
        showMenu()

        val input = readlnOrNull()
        when(input) {
            "1" -> parkVehicleProcess(parkingSystem, vehicleFactory)
            "2" -> unParkVehicleProcess(parkingSystem)
            "3" -> return
        }

    }

}

fun unParkVehicleProcess(parkingSystem: CoreParkingSystem) {
    println("Please enter your vehicle registration no to un-park")
    val vrn = readln()
    parkingSystem.unParkVehicle(vrn)

    println(".....Thanks for choosing us.....")
}

fun parkVehicleProcess(parkingSystem: CoreParkingSystem, vehicleFactory: VehicleFactory) {
    println()
    println("Please enter your vehicle registration no to park")
    val vrn = readln()
    println("Please choose the vehicle type: 1. Car   2. Bike")
    val vehicleTypeInput = readln()
    val vehicleType = if (vehicleTypeInput == "1") "Car" else "Bike"
    val vehicle = vehicleFactory.getVehicle(vehicleType, vrn)
    parkingSystem.parkVehicle(vehicle)
}
private fun showMenu() {
    println("\n******************************************************")
    println("Please choose an option from below:")
    println("1. Park a vehicle")
    println("2. Un-park the vehicle")
    println("3. Exit the system")
    println("******************************************************")
}