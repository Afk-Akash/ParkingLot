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

        return "Vehicle was parked successfully"
    }

    fun vacateSpot(floorNo: Int) {
        if(!this.isOccupied){
            throw RuntimeException("This spot ${this.spotNumber} at floor $floorNo is already free to park")
        }
        this.isOccupied = false
        this.vehicle = null
    }
}