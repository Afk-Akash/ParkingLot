package org.parkingLot.models.vehicle

class VehicleBike(vrn: String): Vehicle(VehicleType.BIKE, vrn) {

    companion object {
        public val rateOfCharge: Int = 5
    }

    override fun move() {
        println("Bike is moving")
    }
}