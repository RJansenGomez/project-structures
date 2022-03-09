package org.rjansen.structures.jansenpizza.controller.dto

import org.rjansen.structures.jansenpizza.repository.dao.PaymentTypes
import java.time.LocalDateTime

data class PaymentDto(
    val paymentTypes: PaymentTypes,
    val date: LocalDateTime
)