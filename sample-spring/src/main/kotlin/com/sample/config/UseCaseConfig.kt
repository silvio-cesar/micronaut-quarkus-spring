package com.sample.config

import com.sample.core.CreateUseCase
import com.sample.core.MessageGateway
import com.sample.core.Repository
import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class UseCaseConfig {

    @Bean
    @Qualifier("mongodbCreateUseCase")
    fun mongodbCreateUseCase(
        @Qualifier("entityRepository") repository: Repository,
        @Qualifier("kafkaMessageGateway") messageGateway: MessageGateway
    ): CreateUseCase = CreateUseCase(repository, messageGateway)
}