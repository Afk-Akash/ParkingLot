package org.example.parkingFloor

import org.example.models.VehicleBike
import org.example.models.VehicleCar
import org.example.models.VehicleType

class ParkingFloor(
    private val floorNumber: Int
) {
    private lateinit var parkingSpots: List<ParkingSpot>

    constructor(floorNumber: Int, bikeParkingSpot: Int, carParkingSpot: Int) : this(floorNumber) {
        val parkingSpots = mutableListOf<ParkingSpot>()
        for(i in 0 until bikeParkingSpot) {
            parkingSpots.add(ParkingSpot(
                spotNumber = i,
                floorNumber = this.floorNumber,
                isOccupied = false,
                vehicle = VehicleBike(),
                spotType = VehicleType.BIKE
            ))
        }
        for(i in 0 until carParkingSpot) {
            parkingSpots.add(ParkingSpot(
                spotNumber = i,
                floorNumber = this.floorNumber  ,
                isOccupied = false,
                vehicle = VehicleCar(),
                spotType = VehicleType.CAR
            ))
        }
        this.parkingSpots = parkingSpots
    }

    fun freeSpot(): ParkingSpot? {
        for(spot in parkingSpots) {
            if(spot.isOccupied()) return spot
        }
        return null
    }
}