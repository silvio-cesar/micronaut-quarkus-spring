package com.sample.config

import com.sample.core.CreateUseCase
import com.sample.core.MessageGateway
import com.sample.core.Repository
import io.micronaut.context.annotation.Factory
import jakarta.inject.Named
import jakarta.inject.Singleton

@Factory
class UseCaseConfig {

    @Singleton
    @Named("mongodbCreateUseCase")
    fun mongodbCreateUseCase(
        @Named("mongodbEntityRepository") repository: Repository,
        @Named("kafkaMessageGateway") messageGateway: MessageGateway
    ): CreateUseCase = CreateUseCase(repository, messageGateway)
}