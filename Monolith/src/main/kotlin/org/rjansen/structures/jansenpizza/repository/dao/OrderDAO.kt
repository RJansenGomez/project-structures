package org.rjansen.structures.jansenpizza.repository.dao

import org.rjansen.structures.jansenpizza.repository.OrderRepository
import org.springframework.jdbc.core.JdbcTemplate
import org.springframework.jdbc.core.RowMapper
import java.sql.ResultSet
import java.time.LocalDateTime
import java.time.LocalDateTime.now

class OrderDAO(
    var id: String,
    var customerId: String,
    var paymentType: PaymentTypes,
    var productIds: List<String>,
    var creation: LocalDateTime,
):OrderRepository {

    constructor(jdbcTemplate: JdbcTemplate) : this("", "", PaymentTypes.CASH, emptyList(), now()) {
        this.jdbcTemplate = jdbcTemplate
    }

    private lateinit var jdbcTemplate: JdbcTemplate

    companion object {
        const val FIND_BY_ID = "SELECT * FROM ORDERS WHERE ID=?"
        const val FIND_PRODUCT_IDS_BY_ORDER_ID = "SELECT PRODUCT_ID FROM ORDER_PRODUCTS WHERE ORDER_ID=?"
    }

    fun getOrder(orderId: String): OrderDAO {
        val order =  jdbcTemplate.queryForObject(FIND_BY_ID, OrderMapper(), orderId)
            ?: throw RuntimeException("Order not found by $orderId")
        order.productIds = jdbcTemplate.queryForList(FIND_PRODUCT_IDS_BY_ORDER_ID, String::class.java, orderId)
        return order
    }
}

enum class PaymentTypes {
    CREDIT_CARD, BANK_TRANSFER, CASH
}

internal class OrderMapper : RowMapper<OrderDAO> {

    override fun mapRow(resultSet: ResultSet, i: Int): OrderDAO {
        return OrderDAO(
            id = resultSet.getString("id"),
            customerId = resultSet.getString("name"),
            paymentType = PaymentTypes.valueOf(resultSet.getString("payment_type")),
            productIds = emptyList(),
            creation = resultSet.getTimestamp("creation").toLocalDateTime(),
        )
    }
}
