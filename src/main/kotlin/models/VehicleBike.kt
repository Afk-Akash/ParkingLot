package org.example.models

class VehicleBike: Vehicle(VehicleType.BIKE), VehicleMovement {
    override fun move() {
        println("Bike is moving")
    }
}