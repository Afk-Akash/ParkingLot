package org.parkingLot.parkingFloor

import org.parkingLot.models.vehicle.Vehicle
import org.parkingLot.models.vehicle.VehicleType

class ParkingSpot(
    private val spotNumber: Int,
    private val floorNumber: Int,
    private val isOccupied: Boolean,
    private val spotType: VehicleType
) {
    private  lateinit var vehicle: Vehicle

    fun isOccupied(): Boolean {
        return this.isOccupied
    }
}