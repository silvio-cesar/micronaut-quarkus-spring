package com.sample.config

import com.sample.core.CreateUseCase
import com.sample.infrastructure.kafka.KafkaMessageGateway
import com.sample.infrastructure.mongodb.EntityRepository
import jakarta.enterprise.inject.Produces
import jakarta.inject.Named
import jakarta.inject.Singleton

@Singleton
class UseCaseConfig {

    @Produces
    @Named("mongodbCreateUseCase")
    fun mongodbCreateUseCase(
        repository: EntityRepository,
        messageGateway: KafkaMessageGateway
    ): CreateUseCase = CreateUseCase(repository, messageGateway)
}