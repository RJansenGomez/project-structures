package org.rjansen.structures.jansenpizza.controller.dto

import org.rjansen.structures.jansenpizza.services.domain.Category

data class ProductDto ( val id: String,
                        val description: String,
                        val price: Double,
                        val category: Category
)