package org.parkingLot.parkingCore

import org.parkingLot.models.vehicle.VehicleType

class BikeParkingSpot(spotNumber: Int) : ParkingSpot(
    spotNumber,
    false,
    VehicleType.BIKE
)
