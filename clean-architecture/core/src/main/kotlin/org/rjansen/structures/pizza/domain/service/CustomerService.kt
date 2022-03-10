package customer.domain.service

import product.domain.entity.Customer


interface CustomerService {
    fun getCustomer(customerId: String): Customer
}