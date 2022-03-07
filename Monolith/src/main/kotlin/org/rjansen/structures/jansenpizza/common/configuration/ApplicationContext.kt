package org.rjansen.structures.jansenpizza.common.configuration

import org.postgresql.ds.PGSimpleDataSource
import org.rjansen.structures.jansenpizza.repository.dao.CustomerDAO
import org.rjansen.structures.jansenpizza.repository.dao.LocationDAO
import org.rjansen.structures.jansenpizza.repository.dao.OrderDAO
import org.rjansen.structures.jansenpizza.repository.dao.PaymentDAO
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.jdbc.core.JdbcTemplate


@Configuration
class ApplicationContext {
    @Bean
    fun jdbcTemplate(): JdbcTemplate {
        val ds = PGSimpleDataSource()
        ds.serverNames = Array(1) { "localhost" }
        ds.portNumbers = IntArray(1) { 5432 }
        ds.databaseName = "postgres"
        ds.user = "postgres"
        ds.password = "postgres"
        return JdbcTemplate(ds)
    }

    @Bean
    fun customerDAO(jdbcTemplate: JdbcTemplate): CustomerDAO {
        return CustomerDAO(jdbcTemplate)
    }

    @Bean
    fun locationDAO(jdbcTemplate: JdbcTemplate): LocationDAO {
        return LocationDAO(jdbcTemplate)
    }

    @Bean
    fun orderDAO(jdbcTemplate: JdbcTemplate): OrderDAO {
        return OrderDAO(jdbcTemplate)
    }

    @Bean
    fun paymentDAO(jdbcTemplate: JdbcTemplate): PaymentDAO {
        return PaymentDAO(jdbcTemplate)
    }
}