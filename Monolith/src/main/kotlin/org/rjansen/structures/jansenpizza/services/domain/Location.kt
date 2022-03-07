package org.rjansen.structures.jansenpizza.services.domain

data class Country( val name: String, val iso2: String)
data class City(val name: String, val country: Country)