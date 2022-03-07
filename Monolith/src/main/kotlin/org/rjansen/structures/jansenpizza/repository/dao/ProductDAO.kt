package org.rjansen.structures.jansenpizza.repository.dao

import org.rjansen.structures.jansenpizza.repository.ProductRepository
import org.springframework.jdbc.core.JdbcTemplate
import org.springframework.jdbc.core.RowMapper
import java.sql.ResultSet

class ProductDAO(
    var id: String,
    var name: String,
    var age: Int,
    var cityId: String,
    var address: String,
    var zipCode: String
) : ProductRepository {

    constructor(jdbcTemplate: JdbcTemplate) : this("", "", 0, "", "", "") {
        this.jdbcTemplate = jdbcTemplate
    }

    private lateinit var jdbcTemplate: JdbcTemplate

    companion object {
        const val FIND_BY_ID = "SELECT * FROM CUSTOMERS WHERE ID=?"
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
            name = resultSet.getString("name"),
            age = resultSet.getInt("age"),
            zipCode = resultSet.getString("zipCode"),
            cityId = resultSet.getString("city_id"),
            address = resultSet.getString("address"),
        )
    }
}