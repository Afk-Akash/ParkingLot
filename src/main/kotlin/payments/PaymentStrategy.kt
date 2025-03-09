package org.example.payments

interface PaymentStrategy {
    fun processPayment(amount: Double)
}