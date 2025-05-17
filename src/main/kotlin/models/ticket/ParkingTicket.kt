package org.parkingLot.models.ticket

import org.parkingLot.models.vehicle.Vehicle
import java.time.LocalDateTime

data class ParkingTicket(
    val ticketId: String,
    val vehicle: Vehicle,
    val issuedTime: LocalDateTime,
    val parkingFloorNo: Int,
    val parkingSpotNo: Int,
    var isActive: Boolean
)
