package org.parkingLot.parkingCore

import org.parkingLot.models.vehicle.Vehicle
import org.parkingLot.models.vehicle.VehicleType

open class ParkingSpot(
    val spotNumber: Int,
    private var isOccupied: Boolean,
    val spotType: VehicleType
) {
    private var vehicle: Vehicle? = null

    fun isOccupied(): Boolean {
        return this.isOccupied
    }

    fun assignVehicle(vehicle: Vehicle): String {
        if(isOccupied()){
            throw IllegalStateException("Parking spot with id $spotNumber is already occupied")
        }

        if(spotType != vehicle.vehicleType){
            throw IllegalStateException("this parking spot is for $spotType vehicle type")
        }

        this.isOccupied = true
        this.vehicle = vehicle

        println("Vehicle was parked successfully")
        return "Vehicle was parked successfully"
    }

    fun vacateSpot() {
        if(!this.isOccupied){
            throw RuntimeException("This spot ${this.spotNumber} is already free to park")
        }
        println("ParkingSpot: parking spot with $spotNumber available now")
        this.isOccupied = false
        this.vehicle = null
    }
}