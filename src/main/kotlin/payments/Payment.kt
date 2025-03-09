package org.example.payments

class Payment(
    private val amount: Double,
    private val paymentStrategy: PaymentStrategy
) {
    fun pay() {
        paymentStrategy.processPayment(amount)
    }
}