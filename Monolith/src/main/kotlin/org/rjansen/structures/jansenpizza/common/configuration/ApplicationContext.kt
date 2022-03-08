package org.rjansen.structures.jansenpizza.common.configuration

import org.postgresql.ds.PGSimpleDataSource
import org.rjansen.structures.jansenpizza.repository.dao.*
import org.rjansen.structures.jansenpizza.services.CustomerService
import org.rjansen.structures.jansenpizza.services.OrderService
import org.rjansen.structures.jansenpizza.services.PaymentService
import org.rjansen.structures.jansenpizza.services.ProductService
import org.rjansen.structures.jansenpizza.services.impl.CustomerServiceImpl
import org.rjansen.structures.jansenpizza.services.impl.OrderServiceImpl
import org.rjansen.structures.jansenpizza.services.impl.PaymentServiceImpl
import org.rjansen.structures.jansenpizza.services.impl.ProductServiceImpl
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

    @Bean
    fun productDAO(jdbcTemplate: JdbcTemplate): ProductDAO {
        return ProductDAO(jdbcTemplate)
    }

    @Bean
    fun customerService(customerDao: CustomerDAO): CustomerService {
        return CustomerServiceImpl(customerDao)
    }

    @Bean
    fun orderService(orderDAO: OrderDAO): OrderService {
        return OrderServiceImpl(orderDAO)
    }

    @Bean
    fun paymentService(paymentDAO: PaymentDAO): PaymentService {
        return PaymentServiceImpl(paymentDAO)
    }

    @Bean
    fun productService(productDAO: ProductDAO): ProductService {
        return ProductServiceImpl(productDAO)
    }
}