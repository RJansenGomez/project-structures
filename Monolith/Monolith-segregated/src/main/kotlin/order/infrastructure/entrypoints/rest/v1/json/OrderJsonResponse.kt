package order.infrastructure.entrypoints.rest.v1.json

import java.time.LocalDateTime

data class OrderJsonResponse(
    val customerData: CustomerJsonResponse,
    val paymentData: PaymentJsonResponse,
    val id: String,
    val products: Map<ProductJsonResponse, Int>,
    val date: LocalDateTime
)