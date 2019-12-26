package com.spike.reactivedependencies.domain

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document

@Document
class Customer(@Id val name: String)
