package org.parkingLot.models

class VehicleBike(vrn: String): Vehicle(VehicleType.BIKE, vrn) {
    override fun move() {
        println("Bike is moving")
    }
}