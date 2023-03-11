package com.sample.infrastructure.kafka

import io.quarkus.runtime.annotations.RegisterForReflection
import java.time.Instant

@RegisterForReflection
data class SampleDto(
    val id: String,
    val externalId: String?,
    val name: String,
    val email: String,
    val cellPhone: String,
    val createdAt: Instant,
    val updatedAt: Instant
)