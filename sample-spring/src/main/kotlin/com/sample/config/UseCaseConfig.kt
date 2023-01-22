package com.sample.config

import com.sample.core.CreateUseCase
import com.sample.infrastructure.kafka.KafkaMessageGateway
import com.sample.infrastructure.mongodb.EntityRepository
import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class UseCaseConfig {

    @Bean
    @Qualifier("mongodbCreateUseCase")
    fun mongodbCreateUseCase(
        repository: EntityRepository,
        messageGateway: KafkaMessageGateway
    ): CreateUseCase = CreateUseCase(repository, messageGateway)
}