package org.parkingLot.models

class VehicleCar(vrn: String): Vehicle(vehicleType = VehicleType.CAR, vrn){
    override fun move() {
        println("Car is moving")
    }
}