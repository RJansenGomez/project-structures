package customer.infrastructure.entrypoints.rest.v1

import customer.domain.service.CustomerService
import customer.infrastructure.entrypoints.rest.v1.json.CustomerJsonResponse
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/customers")
class CustomerController(val customerService: CustomerService) {

    @GetMapping("/{customerId}")
    fun getCustomer(@PathVariable customerId: String): ResponseEntity<CustomerJsonResponse> {
        return ResponseEntity.ok(CustomerJsonResponse.from(customerService.getCustomer(customerId)))
    }

}