package customer.domain.repository

import product.domain.entity.Customer

interface CustomerRepository {
    fun findById(customerId: String): Customer
}