package org.rjansen.structures.jansenpizza.services.domain

import java.time.LocalDateTime

data class Order(
    val id: String,
    val products: Map<Product, Int>,
    val customer: Customer,
    val payment: Payment,
    val date: LocalDateTime
)