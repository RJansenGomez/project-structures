package org.rjansen.structures.jansenpizza.repository.dao

import org.rjansen.structures.jansenpizza.repository.CustomerRepository
import org.springframework.jdbc.core.JdbcTemplate
import org.springframework.jdbc.core.RowMapper
import java.sql.ResultSet

class CustomerDAO(
    var id: String,
    var name: String,
    var age: Int,
    var cityId: String,
    var address: String,
    var zipCode: String
):CustomerRepository {

    constructor(jdbcTemplate: JdbcTemplate) : this("", "", 0, "", "", "") {
        this.jdbcTemplate = jdbcTemplate
    }

    private lateinit var jdbcTemplate: JdbcTemplate

    companion object {
        const val FIND_BY_ID = "SELECT * FROM CUSTOMERS WHERE ID=?"
    }

    fun getCustomer(customerId: String): CustomerDAO {
        return jdbcTemplate.queryForObject(FIND_BY_ID, CustomerMapper(), customerId)
            ?: throw RuntimeException("Customer not found by $customerId")
    }
}

internal class CustomerMapper : RowMapper<CustomerDAO> {

    override fun mapRow(resultSet: ResultSet, i: Int): CustomerDAO {
        return CustomerDAO(
            id = resultSet.getString("id"),
            name = resultSet.getString("name"),
            age = resultSet.getInt("age"),
            zipCode = resultSet.getString("zipCode"),
            cityId = resultSet.getString("city_id"),
            address = resultSet.getString("address"),
        )
    }
}