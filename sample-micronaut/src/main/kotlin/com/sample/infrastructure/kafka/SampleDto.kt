package com.sample.infrastructure.kafka

import java.time.Instant

data class SampleDto(
    val id: String,
    val externalId: String,
    val name: String,
    val email: String,
    val cellPhone: String,
    val createdAt: Instant,
    val updatedAt: Instant
)