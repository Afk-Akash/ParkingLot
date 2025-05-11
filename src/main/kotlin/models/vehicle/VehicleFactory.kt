package org.parkingLot.models.vehicle

class VehicleFactory {
    fun getVehicle(type: String, vrn: String): Vehicle {
        when (type ){
            "Bike" -> return VehicleBike(vrn)
            "Car" -> return VehicleCar(vrn)
        }
        throw Error("Vehicle is neither car nor bike")
    }
}