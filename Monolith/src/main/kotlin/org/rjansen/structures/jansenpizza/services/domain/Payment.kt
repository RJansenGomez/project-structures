package org.rjansen.structures.jansenpizza.services.domain

import java.time.LocalDateTime

data class Payment(
    val creditCard: CreditCard?,
    val bankTransfer: BankAccount?,
    val cash: Boolean,
    val date: LocalDateTime
)

data class CreditCard(val number: String, val owner: String)
data class BankAccount(val iban: String, val owner: String)