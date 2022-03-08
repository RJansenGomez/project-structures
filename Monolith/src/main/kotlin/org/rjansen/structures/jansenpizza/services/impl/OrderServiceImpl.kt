package org.rjansen.structures.jansenpizza.services.impl

import org.rjansen.structures.jansenpizza.repository.dao.OrderDAO
import org.rjansen.structures.jansenpizza.services.OrderService

class OrderServiceImpl(val orderDAO: OrderDAO) : OrderService {
}