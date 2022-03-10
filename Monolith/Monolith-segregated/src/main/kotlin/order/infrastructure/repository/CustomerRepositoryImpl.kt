package order.infrastructure.repository

import customer.infrastructure.entrypoints.rest.v1.CustomerController
import customer.infrastructure.entrypoints.rest.v1.json.CustomerJsonResponse
import order.domain.repository.CustomerRepository

class CustomerRepositoryImpl(private val customerController: CustomerController) : CustomerRepository {

    override fun getCustomer(customerId: String): CustomerJsonResponse {
        return customerController.getCustomer(customerId).body!!
    }
}