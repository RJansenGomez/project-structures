package customer.infrastructure.entrypoints.rest.v1.json

import org.rjansen.structures.pizza.domain.entity.Customer


data class CustomerJsonResponse(val id: String, val name: String, val age: Int) {
    companion object {
        fun from(customer: Customer): CustomerJsonResponse {
            return CustomerJsonResponse(customer.id, customer.name, customer.age)
        }
    }
}