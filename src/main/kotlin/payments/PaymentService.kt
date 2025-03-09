package org.example.payments

class PaymentService{

    fun paymentService(amount: Double) {
        println("Please input your mode of payment : 1 -> Cash && 2 -> UPI")
        val input = readln()

        val payment: Payment = when(input) {
            "1" -> Payment(amount, CashPayment())
            "2" -> Payment(amount, UPIPayment())
            else -> throw IllegalArgumentException("")
        }
        payment.pay()
    }
}