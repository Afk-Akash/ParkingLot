package org.example.payments

class UPIPayment: PaymentStrategy {
    override fun processPayment(amount: Double) {
        println("processing payment using UPI")
    }
}