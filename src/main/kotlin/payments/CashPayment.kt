package org.example.payments

class CashPayment: PaymentStrategy {
    override fun processPayment(amount: Double) {
        println("Processing payment using cash")
    }
}