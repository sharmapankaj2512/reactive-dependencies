package com.spike.reactivedependencies.domain

import com.spike.reactivedependencies.domain.Customer
import java.util.concurrent.CompletableFuture

interface CustomerGateway {
    fun create(customer: Customer): CompletableFuture<Customer>
    fun find(name: String): CompletableFuture<Customer>
}