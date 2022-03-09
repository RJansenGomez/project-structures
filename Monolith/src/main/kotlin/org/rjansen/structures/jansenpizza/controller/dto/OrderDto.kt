package org.rjansen.structures.jansenpizza.controller.dto

import java.time.LocalDateTime

data class OrderDto(
    val customerData: CustomerDto,
    val paymentData: PaymentDto,
    val id: String,
    val products: Map<ProductDto, Int>,
    val date: LocalDateTime
)