package com.spike.reactivedependencies.domain

import java.util.concurrent.CompletableFuture

class AddCustomer(private val customerGateway: CustomerGateway) {
    operator fun invoke(name: String): CompletableFuture<Customer> {
        return customerGateway.create(Customer(name))
    }
}
