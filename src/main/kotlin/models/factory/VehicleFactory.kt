package org.parkingLot.models.factory

import org.parkingLot.models.vehicle.Vehicle
import org.parkingLot.models.vehicle.VehicleBike
import org.parkingLot.models.vehicle.VehicleCar

class VehicleFactory {
    fun getVehicle(type: String, vrn: String): Vehicle {
        when (type ){
            "Bike" -> return VehicleBike(vrn)
            "Car" -> return VehicleCar(vrn)
        }
        throw Error("Vehicle is neither car nor bike")
    }
}