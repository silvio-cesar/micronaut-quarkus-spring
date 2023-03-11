package com.sample.entrypoint.kafka.external

import com.sample.constant.KafkaConstant
import com.sample.core.CreateUseCase
import jakarta.enterprise.context.ApplicationScoped
import jakarta.inject.Named
import org.apache.kafka.clients.consumer.ConsumerRecord
import org.eclipse.microprofile.reactive.messaging.Incoming
import org.slf4j.Logger
import org.slf4j.LoggerFactory

@ApplicationScoped
class ExternalKafkaListener(
    @Named("mongodbCreateUseCase") private val createUseCase: CreateUseCase
) {

  private val logger: Logger = LoggerFactory.getLogger(ExternalKafkaListener::class.java)

  @Incoming("external-in")
  fun receive(message: ConsumerRecord<String, ExternalSampleDto>) {
    val externalSampleId = message.key()
    val sample = message.value()
    val operation = message.headers()?.lastHeader(KafkaConstant.OPERATION_HEADER)?.value()?.let { String(it) }
    logger.info("Create received {} with operation {}", externalSampleId, operation)
    if (operation == KafkaConstant.CREATE_OPERATION) {
      createUseCase.create(sample.toDomain(externalSampleId))
    }
  }
}
