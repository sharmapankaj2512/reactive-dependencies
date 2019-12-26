package com.spike.reactivedependencies.resource

import com.spike.reactivedependencies.domain.AddCustomer
import com.spike.reactivedependencies.domain.Customer
import com.spike.reactivedependencies.domain.CustomerGateway
import com.spike.reactivedependencies.domain.GetCustomer
import org.springframework.web.bind.annotation.*
import reactor.core.publisher.Mono

@RestController
class CustomerController(customerGateway: CustomerGateway) {
    val addCustomer = AddCustomer(customerGateway)
    val getCustomer = GetCustomer(customerGateway)

    @PostMapping("/api/v1/customers")
    fun addCustomerResource(@RequestBody data: CustomerData): Mono<Customer> {
        return Mono.fromFuture(addCustomer(data.name))
    }

    @GetMapping("/api/v1/customers/{name}")
    fun getCustomerResource(@PathVariable name: String): Mono<Customer> {
        return Mono.fromFuture(getCustomer(name))
    }

    data class CustomerData(val name: String)
}