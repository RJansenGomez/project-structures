package org.rjansen.structures.jansenpizza.services.domain

data class Product(
    val id: String,
    val description: String,
    val price: Double,
    val category: Category
)

data class Category(val id: String, val name: String, val subCategories: Set<Category>)