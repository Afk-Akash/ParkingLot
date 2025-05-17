package org.parkingLot.models.payment

class PaymentUserInput {

    fun getUserPaymentChoice(): String {
        println("Choose payment method: 1. card / 2. upi / 3. cash")
        val input = readlnOrNull()
        return input?.lowercase()?.trim() ?: ""
    }
}