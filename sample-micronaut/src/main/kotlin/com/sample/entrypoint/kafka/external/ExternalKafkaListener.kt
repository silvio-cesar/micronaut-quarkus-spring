package com.sample.entrypoint.kafka.external

import com.sample.constant.KafkaConstant
import com.sample.core.CreateUseCase
import io.micronaut.configuration.kafka.annotation.KafkaKey
import io.micronaut.configuration.kafka.annotation.KafkaListener
import io.micronaut.configuration.kafka.annotation.OffsetReset
import io.micronaut.configuration.kafka.annotation.Topic
import io.micronaut.messaging.annotation.MessageBody
import io.micronaut.messaging.annotation.MessageHeader
import jakarta.inject.Named
import org.slf4j.Logger
import org.slf4j.LoggerFactory

@KafkaListener(
    offsetReset = OffsetReset.EARLIEST,
    groupId = "\${kafka.consumers.external-sample.group-id}"
)
class ExternalKafkaListener(
    @Named("mongodbCreateUseCase") private val createUseCase: CreateUseCase
) {

    private val logger: Logger = LoggerFactory.getLogger(ExternalKafkaListener::class.java)

    @Topic("\${kafka.consumers.external-sample.topic}")
    fun receive(
        @KafkaKey externalSampleId: String,
        @MessageBody sample: ExternalSampleDto,
        @MessageHeader("x-operation") operation: String) {
        logger.info("Create received {} with operation {}", externalSampleId, operation)
        if (operation == KafkaConstant.CREATE_OPERATION) {
            createUseCase.create(sample.toDto(externalSampleId))
        }
    }
}