package com.sample.infrastructure.kafka

import com.sample.constant.KafkaConstant
import com.sample.core.MessageGateway
import com.sample.core.Sample
import io.smallrye.reactive.messaging.kafka.KafkaRecord
import jakarta.enterprise.context.ApplicationScoped
import org.eclipse.microprofile.reactive.messaging.Channel
import org.eclipse.microprofile.reactive.messaging.Emitter

@ApplicationScoped
class KafkaMessageGateway(
    @Channel("internal-out") private val emitter: Emitter<SampleDto>
): MessageGateway {

    override fun create(sample: Sample) {
        produce(KafkaConstant.CREATE_OPERATION, sample)
    }

    override fun update(sample: Sample) {
        produce(KafkaConstant.UPDATE_OPERATION, sample)
    }

    private fun produce(operation: String, sample: Sample) {
        val dto = sample.toDto()
        emitter.send(
            KafkaRecord
                .of(dto.id, dto)
                .withHeader(KafkaConstant.OPERATION_HEADER, operation)
        )
    }
}