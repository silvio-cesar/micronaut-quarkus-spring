package com.sample.infrastructure.kafka

import com.sample.constant.KafkaConstant
import com.sample.core.MessageGateway
import com.sample.core.Sample
import org.apache.kafka.clients.producer.Producer
import org.apache.kafka.clients.producer.ProducerRecord
import org.apache.kafka.common.header.internals.RecordHeader
import java.time.Instant

class KafkaMessageGateway(
    private val producer: Producer<String, SampleDto>,
    private val topic: String
): MessageGateway {

    override fun create(sample: Sample) {
        produce(KafkaConstant.CREATE_OPERATION, sample)
    }

    override fun update(sample: Sample) {
        TODO("Not yet implemented")
    }

    private fun produce(operation: String, sample: Sample) {
        val headers = mutableListOf<RecordHeader>()
        headers.add(RecordHeader("x-operation", operation.toByteArray()))
        val dto = sample.toDto()
        producer.send(
            ProducerRecord(
                topic,
                null,
                Instant.now().toEpochMilli(),
                dto.id,
                dto,
                headers
        )
        )
    }
}