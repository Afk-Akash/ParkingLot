package org.parkingLot.models.payment

import java.math.BigDecimal

class PaymentHandler {

    fun getUserPaymentChoice(): String {
        println("Choose payment method: 1. card / 2. upi / 3. cash")
        val input = readlnOrNull()
        return input?.lowercase()?.trim() ?: ""
    }

    fun paymentProcessor(amount: BigDecimal) {
        val selectedPaymentMethod = getUserPaymentChoice()

        when (selectedPaymentMethod) {
            "1" -> PaymentService(amount, CardPayment())
            "2" -> PaymentService(amount, UpiPayment())
            else -> throw RuntimeException("Payment method was not selected properly")
        }
    }
}