package org.rjansen.structures.jansenpizza.repository.dao


import org.rjansen.structures.jansenpizza.repository.PaymentRepository
import org.springframework.jdbc.core.JdbcTemplate
import org.springframework.jdbc.core.RowMapper
import java.sql.ResultSet

class PaymentDAO(
    var id: String,
    var customerId: String,
    var iban: String,
    var creditCardNumber: String,

    ) : PaymentRepository {

    constructor(jdbcTemplate: JdbcTemplate) : this("", "", "", "") {
        this.jdbcTemplate = jdbcTemplate
    }

    private lateinit var jdbcTemplate: JdbcTemplate

    companion object {
        const val FIND_BY_ID = "SELECT * FROM CUSTOMER_PAYMENTS WHERE ID=?"
        const val FIND_BY_CUSTOMER_ID = "SELECT * FROM CUSTOMER_PAYMENTS WHERE CUSTOMER_ID=?"
    }

    fun getPaymentDataByCustomerId(customerId: String): PaymentDAO {
        return jdbcTemplate.queryForObject(FIND_BY_CUSTOMER_ID, PaymentMapper(), customerId)
            ?: throw RuntimeException("Payment data not found by $customerId")
    }

    fun getPaymentData(id: String): PaymentDAO {
        return jdbcTemplate.queryForObject(FIND_BY_ID, PaymentMapper(), id)
            ?: throw RuntimeException("Payment data not found by $id")
    }
}

internal class PaymentMapper : RowMapper<PaymentDAO> {

    override fun mapRow(resultSet: ResultSet, i: Int): PaymentDAO {
        return PaymentDAO(
            id = resultSet.getString("id"),
            customerId = resultSet.getString("customerId"),
            iban = resultSet.getString("iban"),
            creditCardNumber = resultSet.getString("credit_card_number")
        )
    }
}