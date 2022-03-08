package org.rjansen.structures.jansenpizza.controller.dto

import org.rjansen.structures.jansenpizza.services.domain.Customer

data class CustomerDto(val id: String, val name: String, val age: Int) {
    companion object {
        fun from(customer: Customer): CustomerDto {
            return CustomerDto(customer.id, customer.name, customer.age)
        }
    }
}