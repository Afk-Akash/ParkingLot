package org.example

import org.example.models.VehicleFactory

fun main() {
    val factory = VehicleFactory()

    val car = factory.getVehicle("Car")
    val bike = factory.getVehicle("Bike")

    car.move()
    bike.move()
}