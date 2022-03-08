package org.rjansen.structures.jansenpizza.repository.dao

import org.rjansen.structures.jansenpizza.repository.ProductRepository
import org.springframework.jdbc.core.JdbcTemplate
import org.springframework.jdbc.core.RowMapper
import java.sql.ResultSet

class ProductDAO(
    var id: String,
    var description: String,
    var price: Double,
    var categoryId: String
) : ProductRepository {

    constructor(jdbcTemplate: JdbcTemplate) : this("", "", 0.0, "") {
        this.jdbcTemplate = jdbcTemplate
    }

    private lateinit var jdbcTemplate: JdbcTemplate

    companion object {
        const val FIND_BY_ID = "SELECT * FROM PRODUCTS WHERE ID=?"
    }

    fun getProduct(productId: String): ProductDAO {
        return jdbcTemplate.queryForObject(FIND_BY_ID, ProductMapper(), productId)
            ?: throw RuntimeException("Product not found by $productId")
    }
}

internal class ProductMapper : RowMapper<ProductDAO> {

    override fun mapRow(resultSet: ResultSet, i: Int): ProductDAO {
        return ProductDAO(
            id = resultSet.getString("id"),
            description = resultSet.getString("description"),
            price = resultSet.getDouble("price"),
            categoryId = resultSet.getString("category_id")
        )
    }
}