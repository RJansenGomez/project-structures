package order.domain.repository

import customer.infrastructure.entrypoints.rest.v1.json.CustomerJsonResponse

interface CustomerRepository {
    fun getCustomer(customerId: String): CustomerJsonResponse
}