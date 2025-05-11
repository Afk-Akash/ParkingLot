package org.parkingLot.models.payment

import java.math.BigDecimal

class PaymentService(
    val amount: BigDecimal,
    paymentMethod: PaymentStrategy
) {
    init {
        paymentMethod.processPayment(amount)
    }
}