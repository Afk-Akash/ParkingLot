package org.example.models

class VehicleCar: Vehicle(vehicleType = VehicleType.CAR), VehicleMovement{
    override fun move() {
        println("Car is moving")
    }
}