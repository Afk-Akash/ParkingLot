package org.example.parkingFloor

import org.example.models.Vehicle
import org.example.models.VehicleType

class ParkingSpot(
    private val spotNumber: Int,
    private val floorNumber: Int,
    private val isOccupied: Boolean,
    private val vehicle: Vehicle,
    private val spotType: VehicleType
) {
    fun isOccupied(): Boolean {
        return this.isOccupied
    }
}