package org.parkingLot.parkingCore

import org.parkingLot.models.vehicle.VehicleType

class ParkingFloor(
    val floorNumber: Int
) {
    private lateinit var parkingSpots: List<ParkingSpot>

    constructor(floorNumber: Int, bikeParkingSpot: Int, carParkingSpot: Int) : this(floorNumber) {
        val parkingSpots = mutableListOf<ParkingSpot>()
        for(i in 0 until bikeParkingSpot) {
            parkingSpots.add(
                ParkingSpot(
                spotNumber = i,
                isOccupied = false,
                spotType = VehicleType.BIKE
            )
            )
        }
        for(i in 0 until carParkingSpot) {
            parkingSpots.add(
                ParkingSpot(
                    spotNumber = i+bikeParkingSpot,
                    isOccupied = false,
                    spotType = VehicleType.CAR
                )
            )
        }
        this.parkingSpots = parkingSpots
    }

    fun freeSpot(vehicleType: VehicleType): ParkingSpot? {
        for(spot in parkingSpots) {
            if(!spot.isOccupied() && spot.spotType == vehicleType) return spot
        }
        return null
    }

    fun vacateSpot(parkingSpotId: Int) {
        val parkingSpot = this.parkingSpots[parkingSpotId]
        if(parkingSpot.isOccupied()){
            parkingSpot.vacateSpot(this.floorNumber)
            println("ParkingFloor: parking spot $parkingSpotId was successfully vacated on floor ${this.floorNumber}")
        }else{
            println("ParkingFloor: This parking spot is already vacated")
        }
    }

    fun getSpotById(spotId: Int): ParkingSpot? {
        for(spot in parkingSpots){
            if(spot.spotNumber == spotId) return spot
        }
        println("This spotId does not belong to this floor")
        return null
    }
}