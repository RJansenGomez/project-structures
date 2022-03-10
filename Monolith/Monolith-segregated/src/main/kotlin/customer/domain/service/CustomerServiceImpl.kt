package customer.domain.service

import customer.domain.repository.CustomerRepository
import org.springframework.stereotype.Service
import product.domain.entity.Customer

@Service
class CustomerServiceImpl(val customerRepository: CustomerRepository) : CustomerService {
    override fun getCustomer(customerId: String): Customer {
        return customerRepository.findById(customerId)
    }
}