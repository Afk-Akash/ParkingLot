package org.parkingLot.models.payment

import java.math.BigDecimal

class CardPayment: PaymentStrategy {
    override fun processPayment(amount: BigDecimal) {
        println("initializing card payment for $amount")
    }
}