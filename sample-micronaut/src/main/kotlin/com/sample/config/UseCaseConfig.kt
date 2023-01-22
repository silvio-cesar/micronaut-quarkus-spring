package com.sample.config

import com.sample.core.CreateUseCase
import com.sample.core.MessageGateway
import com.sample.core.Repository
import com.sample.infrastructure.kafka.KafkaMessageGateway
import com.sample.infrastructure.mongodb.EntityRepository
import io.micronaut.context.annotation.Factory
import jakarta.inject.Named
import jakarta.inject.Singleton

@Factory
class UseCaseConfig {

    @Singleton
    @Named("mongodbCreateUseCase")
    fun mongodbCreateUseCase(
        repository: EntityRepository,
        messageGateway: KafkaMessageGateway
    ): CreateUseCase = CreateUseCase(repository, messageGateway)
}