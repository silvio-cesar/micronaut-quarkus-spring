package com.sample.entrypoint.kafka.internal

import com.sample.infrastructure.kafka.SampleDto
import jakarta.enterprise.context.ApplicationScoped
import org.apache.kafka.clients.consumer.ConsumerRecord
import org.eclipse.microprofile.reactive.messaging.Incoming
import org.slf4j.Logger
import org.slf4j.LoggerFactory

@ApplicationScoped
class InternalKafkaListener {

    private val logger: Logger = LoggerFactory.getLogger(InternalKafkaListener::class.java)

    @Incoming("internal-in")
    fun receive(message: ConsumerRecord<String, SampleDto>) {
        logger.info("Sample {} with id {} processed", message.value(), message.key())
    }
}