package org.parkingLot.models.payment

import java.math.BigDecimal

class PaymentService(
    private val paymentStrategy: PaymentStrategy
) {
    fun pay(amount: BigDecimal): Boolean {
        return paymentStrategy.processPayment(amount)
    }
}
