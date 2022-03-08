package org.rjansen.structures.jansenpizza.services

import org.rjansen.structures.jansenpizza.services.domain.Customer

interface CustomerService {
    fun getCustomer(customerId: String): Customer
}