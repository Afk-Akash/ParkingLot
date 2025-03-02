package org.example.models

class VehicleFactory {
    fun getVehicle(type: String): VehicleMovement {
        when (type ){
            "Bike" -> return VehicleBike()
            "Car" -> return VehicleCar()
        }
        throw Error("Vehicle is neither car nor bike")
    }
}