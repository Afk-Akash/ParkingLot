package org.parkingLot.models.payment

import java.math.BigDecimal


class CashPayment: PaymentStrategy {
    override fun processPayment(amount: BigDecimal): Boolean {
        println("cash received $amount")
        return true
    }
}