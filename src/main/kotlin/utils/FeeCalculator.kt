package org.parkingLot.utils

import org.parkingLot.models.ticket.ParkingTicket
import org.parkingLot.models.vehicle.VehicleBike
import org.parkingLot.models.vehicle.VehicleCar
import org.parkingLot.models.vehicle.VehicleType
import java.math.BigDecimal
import java.time.LocalDateTime
import java.time.temporal.ChronoUnit

class FeeCalculator {
    fun calculateFee(parkingTicket: ParkingTicket): BigDecimal {
        val parkingTime = parkingTicket.issuedTime
        val currentTime = LocalDateTime.now().truncatedTo(ChronoUnit.MINUTES)

        val totalMinutesParked = ChronoUnit.MINUTES.between(parkingTime, currentTime)
        println("FeeCalculator: Total minute of parking was $totalMinutesParked")
        val totalHours = BigDecimal((totalMinutesParked + 59) / 60)

        val hourlyRate = when (parkingTicket.vehicle.vehicleType) {
            VehicleType.BIKE -> VehicleBike.rateOfCharge.toBigDecimal()
            VehicleType.CAR -> VehicleCar.rateOfCharge.toBigDecimal()
        }

        return totalHours.multiply(hourlyRate)
    }
}