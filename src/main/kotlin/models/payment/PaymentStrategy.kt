package org.parkingLot.models.payment

import java.math.BigDecimal

interface PaymentStrategy {
    fun processPayment(amount: BigDecimal)
}