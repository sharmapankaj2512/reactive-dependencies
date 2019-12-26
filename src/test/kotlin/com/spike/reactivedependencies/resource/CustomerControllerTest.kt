package com.spike.reactivedependencies.resource

import com.spike.reactivedependencies.domain.Customer
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.data.mongo.AutoConfigureDataMongo
import org.springframework.boot.test.autoconfigure.web.reactive.WebFluxTest
import org.springframework.context.annotation.ComponentScan
import org.springframework.http.HttpHeaders
import org.springframework.test.web.reactive.server.WebTestClient
import org.springframework.web.reactive.function.BodyInserters
import java.time.Duration


@WebFluxTest(CustomerController::class)
@AutoConfigureDataMongo
@ComponentScan("com.spike")
internal class CustomerControllerTest {

    @Autowired
    lateinit var webTestClient: WebTestClient

    @BeforeEach
    fun setUp() {
        webTestClient = webTestClient
                .mutate()
                .responseTimeout(Duration.ofMillis(30000))
                .build()
    }

    @Test
    fun testCustomers() {
        webTestClient.post()
                .uri("/api/v1/customers")
                .header(HttpHeaders.CONTENT_TYPE, "application/json")
                .body(BodyInserters.fromValue(Customer("customer")))
                .exchange()
                .expectStatus().isOk
                .expectBody()
                .json("""
                    |{
                    |   "name": "customer"
                    |}
                """.trimMargin())

        webTestClient.get()
                .uri("/api/v1/customers/customer")
                .header(HttpHeaders.CONTENT_TYPE, "application/json")
                .exchange()
                .expectStatus().isOk
                .expectBody()
                .json("""
                    |{
                    |   "name": "customer"
                    |}
                """.trimMargin())
    }
}