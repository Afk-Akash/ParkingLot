package org.parkingLot.models

open class Vehicle(
    val vehicleType: VehicleType,
    val vrn: String
) {
    open fun move() {
        println("this will define vehicle movement, however this is not needed in parking lot")
    }
}