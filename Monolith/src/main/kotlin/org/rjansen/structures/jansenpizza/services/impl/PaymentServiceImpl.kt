package org.rjansen.structures.jansenpizza.services.impl

import org.rjansen.structures.jansenpizza.repository.dao.PaymentDAO
import org.rjansen.structures.jansenpizza.services.PaymentService

class PaymentServiceImpl(val paymentDAO: PaymentDAO) : PaymentService {
}