package org.parkingLot.models.vehicle

class VehicleCar(vrn: String): Vehicle(vehicleType = VehicleType.CAR, vrn){

    companion object {
        public val rateOfCharge: Int = 10
    }

    override fun move() {
        println("Car is moving")
    }
}