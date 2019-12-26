package com.spike.reactivedependencies.gateway

import com.spike.reactivedependencies.domain.Customer
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.autoconfigure.EnableAutoConfiguration
import org.springframework.boot.autoconfigure.mongo.embedded.EmbeddedMongoAutoConfiguration
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest
import reactor.core.publisher.Flux
import reactor.test.StepVerifier

@DataMongoTest
class CustomerRepositoryTest(@Autowired val repository: CustomerRepository) {
    @Test
    fun test() {
        repository.save(Customer("john")).block()
        val customers: Flux<Customer> = repository.findAll()
        StepVerifier
                .create(customers)
                .assertNext { customer: Customer -> assertEquals("john", customer.name) }
                .expectComplete()
                .verify()
    }
}