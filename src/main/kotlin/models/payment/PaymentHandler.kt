package org.parkingLot.models.payment

import org.parkingLot.factory.PaymentFactory
import org.parkingLot.models.ticket.ParkingTicket
import org.parkingLot.utils.FeeCalculator
import org.parkingLot.models.vehicle.VehicleBike
import org.parkingLot.models.vehicle.VehicleCar
import org.parkingLot.models.vehicle.VehicleType
import java.math.BigDecimal
import java.time.LocalDateTime
import java.time.temporal.ChronoUnit

class PaymentHandler(
    val feeCalculator: FeeCalculator,
    val userInput: PaymentUserInput,
    val paymentFactory: PaymentFactory
) {
    fun process(ticket: ParkingTicket): Boolean {
        val amount = feeCalculator.calculateFee(ticket)
        println("Please pay ₹$amount")
        val mode   = userInput.getUserPaymentChoice()
        val strategy = paymentFactory.getPaymentStrategy(mode)
        val success = PaymentService(strategy).pay(amount)

        if (!success) println("Payment failed—please retry.")
        return success
    }

}