package com.spike.reactivedependencies.domain

import com.spike.reactivedependencies.domain.Customer
import com.spike.reactivedependencies.domain.CustomerGateway
import java.util.concurrent.CompletableFuture

class GetCustomer(private val customerGateway: CustomerGateway) {
    operator fun invoke(name: String): CompletableFuture<Customer> {
        return customerGateway.find(name)
    }
}
