package org.rjansen.structures.jansenpizza.controller.dto

data class CategoryDto(val id: String, val name: String, val subCategories: Set<CategoryDto>)