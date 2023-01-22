package com.sample.entrypoint.kafka.external

import com.sample.constant.KafkaConstant
import com.sample.core.CreateUseCase
import java.util.function.Consumer
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.context.annotation.Bean
import org.springframework.kafka.support.KafkaHeaders
import org.springframework.messaging.Message
import org.springframework.stereotype.Component

@Component
class ExternalKafkaListener(
    @Qualifier("mongodbCreateUseCase") private val createUseCase: CreateUseCase
) {

  private val logger: Logger = LoggerFactory.getLogger(ExternalKafkaListener::class.java)

  @Bean
  fun external() =
      Consumer<Message<ExternalSampleDto>> { message ->
        run {
          val externalId = message.headers[KafkaHeaders.RECEIVED_KEY].toString()
          val operation = message.headers[KafkaConstant.OPERATION_HEADER].toString()
          logger.info("External sample received with externalId {} and operation {}", externalId, operation)
          if (operation == KafkaConstant.CREATE_OPERATION) {
            createUseCase.create(
                message.payload.toDomain(externalId))
          }
        }
      }
}
