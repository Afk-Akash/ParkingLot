package org.parkingLot.models.factory

import org.parkingLot.models.payment.CardPayment
import org.parkingLot.models.payment.CashPayment
import org.parkingLot.models.payment.PaymentStrategy
import org.parkingLot.models.payment.UpiPayment

class PaymentFactory {
    fun getPaymentStrategy(userInput: String): PaymentStrategy {
        return when(userInput){
            "1" -> CardPayment()
            "2" -> UpiPayment()
            "3" -> CashPayment()
            else -> {
                throw IllegalArgumentException("User input is not allowed while choosing payment method")
            }
        }
    }
}