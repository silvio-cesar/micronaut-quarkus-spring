package com.sample.infrastructure.kafka

import com.sample.constant.KafkaConstant
import com.sample.core.MessageGateway
import com.sample.core.Sample
import org.springframework.cloud.stream.function.StreamBridge
import org.springframework.kafka.support.KafkaHeaders
import org.springframework.messaging.support.MessageBuilder
import org.springframework.stereotype.Component

@Component
class KafkaMessageGateway(
    private val bridge: StreamBridge
): MessageGateway {

    override fun create(sample: Sample) {
        produce(KafkaConstant.CREATE_OPERATION, sample)
    }

    override fun update(sample: Sample) {
        produce(KafkaConstant.UPDATE_OPERATION, sample)
    }

    private fun produce(operation: String, sample: Sample) {
        val dto = sample.toDto()
        val message = MessageBuilder
            .withPayload(dto)
            .setHeader(KafkaConstant.OPERATION_HEADER, operation)
            .setHeader(KafkaHeaders.KEY, dto.id)
            .build()
        bridge.send("internal-out-0", message)
    }
}