package com.spike.reactivedependencies.gateway

import com.spike.reactivedependencies.domain.Customer
import org.springframework.data.repository.reactive.ReactiveCrudRepository
import org.springframework.stereotype.Repository

@Repository
interface CustomerRepository: ReactiveCrudRepository<Customer, String>
