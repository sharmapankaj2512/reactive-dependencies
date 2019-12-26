package com.spike.reactivedependencies.gateway

import com.spike.reactivedependencies.domain.Customer
import com.spike.reactivedependencies.domain.CustomerGateway
import io.netty.util.concurrent.CompleteFuture
import org.springframework.stereotype.Component
import java.util.concurrent.CompletableFuture

@Component
class MongoCustomerGateway(val customerRepository: CustomerRepository) : CustomerGateway {
    override fun create(customer: Customer): CompletableFuture<Customer> {
        return customerRepository.save(customer).toFuture()
    }

    override fun find(name: String): CompletableFuture<Customer> {
        return customerRepository.findById(name).toFuture()
    }
}
