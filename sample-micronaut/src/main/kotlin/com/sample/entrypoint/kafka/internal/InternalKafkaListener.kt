package com.sample.entrypoint.kafka.internal

import com.sample.infrastructure.kafka.SampleDto
import io.micronaut.configuration.kafka.annotation.KafkaKey
import io.micronaut.configuration.kafka.annotation.KafkaListener
import io.micronaut.configuration.kafka.annotation.OffsetReset
import io.micronaut.configuration.kafka.annotation.Topic
import io.micronaut.messaging.annotation.MessageBody
import org.slf4j.Logger
import org.slf4j.LoggerFactory

@KafkaListener(
    offsetReset = OffsetReset.EARLIEST,
    groupId = "\${kafka.consumers.internal.group-id}"
)
class InternalKafkaListener {
    private val logger: Logger = LoggerFactory.getLogger(InternalKafkaListener::class.java)

    @Topic("\${kafka.consumers.internal.topic}")
    fun receive(
        @KafkaKey sampleId: String,
        @MessageBody sample: SampleDto) {
        logger.info("Sample {} with id {} processed", sample, sampleId)
    }
}