package order.infrastructure.entrypoints.rest.v1.json

import java.time.LocalDateTime

data class PaymentJsonResponse(
    val paymentTypes: PaymentTypes,
    val date: LocalDateTime
)

enum class PaymentTypes {
    CREDIT_CARD, BANK_TRANSFER, CASH
}