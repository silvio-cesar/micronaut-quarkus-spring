package com.sample.core

import org.slf4j.Logger
import org.slf4j.LoggerFactory

class CreateUseCase(
    private val repository: Repository,
    private val messageGateway: MessageGateway
) {

    private val logger: Logger = LoggerFactory.getLogger(CreateUseCase::class.java)

    fun create(sample: Sample): Sample {
        logger.info("Creating sample {}", sample.name)
       val created = repository.create(sample)
        messageGateway.create(created)
        return created
    }
}