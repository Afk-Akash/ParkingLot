package org.parkingLot.models.payment

import java.math.BigDecimal

class UpiPayment: PaymentStrategy {
    override fun processPayment(amount: BigDecimal): Boolean {
        println("initializing upi payment for $amount")
        return true
    }
}