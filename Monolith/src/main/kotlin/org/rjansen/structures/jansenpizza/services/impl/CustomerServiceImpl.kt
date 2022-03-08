package org.rjansen.structures.jansenpizza.services.impl

import org.rjansen.structures.jansenpizza.repository.dao.CustomerDAO
import org.rjansen.structures.jansenpizza.services.CustomerService

class CustomerServiceImpl(val customerDAO: CustomerDAO) : CustomerService {
}