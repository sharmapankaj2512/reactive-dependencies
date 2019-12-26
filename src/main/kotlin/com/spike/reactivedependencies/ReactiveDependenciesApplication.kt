package com.spike.reactivedependencies

import com.mongodb.reactivestreams.client.MongoClient
import com.mongodb.reactivestreams.client.MongoClients
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.data.mongodb.config.AbstractReactiveMongoConfiguration
import org.springframework.data.mongodb.repository.config.EnableReactiveMongoRepositories

@SpringBootApplication
@EnableReactiveMongoRepositories
class ReactiveDependenciesApplication : AbstractReactiveMongoConfiguration() {
    override fun reactiveMongoClient(): MongoClient {
        return MongoClients.create()
    }

    override fun getDatabaseName(): String {
        return "reactive"
    }
}

fun main(args: Array<String>) {
    runApplication<ReactiveDependenciesApplication>(*args)
}
