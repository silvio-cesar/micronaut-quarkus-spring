package com.sample.config

import com.sample.infrastructure.kafka.KafkaMessageGateway
import com.sample.infrastructure.kafka.SampleDto
import io.micronaut.configuration.kafka.annotation.KafkaClient
import io.micronaut.context.annotation.Factory
import io.micronaut.context.annotation.Property
import jakarta.inject.Named
import jakarta.inject.Singleton
import org.apache.kafka.clients.producer.Producer

@Factory
class KafkaProducerConfig {

    @Singleton
    @Named("kafkaMessageGateway")
    fun customerKafkaMessageGateway(
        @KafkaClient("customer-producer") producer: Producer<String, SampleDto>,
        @Property(name = "kafka.producers.sample-producer.topic") topic: String
    ) = KafkaMessageGateway(producer,topic)
}