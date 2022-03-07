package org.rjansen.structures.jansenpizza.services.domain

data class Customer(val name: String, val id: String, val age: Int, val address: Address)
data class Address(val address: String, val zipCode: String, val city: City)
