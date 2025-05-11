package org.parkingLot

import org.parkingLot.models.VehicleFactory

fun main() {
    val factory = VehicleFactory()

    val car = factory.getVehicle("Car", "BR00AA0000")
    val bike = factory.getVehicle("Bike", "UP12AC9898")

    println(car.vrn)
    println(bike.vrn)

    car.move()
    bike.move()
}