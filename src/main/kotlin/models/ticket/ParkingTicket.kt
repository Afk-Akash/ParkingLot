package org.parkingLot.models.ticket

import org.parkingLot.models.vehicle.Vehicle
import java.time.LocalDateTime

class ParkingTicket(
    val vehicle: Vehicle
) {
    private lateinit var dateTime: LocalDateTime

    init {
        println("ParkingTicket: initializing date and time to the ParkingTicket")
        dateTime = LocalDateTime.now()
    }

}