package order.infrastructure.repository.rest

import product.domain.entity.Customer

data class CustomerJsonResponse(val id: String, val name: String, val age: Int) {
    companion object {
        fun from(customer: Customer): CustomerJsonResponse {
            return CustomerJsonResponse(customer.id, customer.name, customer.age)
        }
    }
}