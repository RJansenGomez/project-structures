package org.rjansen.structures.jansenpizza.controller

import org.rjansen.structures.jansenpizza.controller.dto.CustomerDto
import org.rjansen.structures.jansenpizza.services.CustomerService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/customers")
class CustomerController(val customerService: CustomerService) {

    @GetMapping("/{customerId}")
    fun getCustomer(@PathVariable customerId: String): ResponseEntity<CustomerDto> {
        return ResponseEntity.ok(CustomerDto.from(customerService.getCustomer(customerId)))
    }

}