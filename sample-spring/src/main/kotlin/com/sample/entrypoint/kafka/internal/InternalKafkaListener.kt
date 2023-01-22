package com.sample.entrypoint.kafka.internal

import com.sample.infrastructure.kafka.SampleDto
import java.util.function.Consumer
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.context.annotation.Bean
import org.springframework.kafka.support.KafkaHeaders
import org.springframework.messaging.Message
import org.springframework.stereotype.Component

@Component
class InternalKafkaListener {

  private val logger: Logger = LoggerFactory.getLogger(InternalKafkaListener::class.java)

  @Bean
  fun internal() =
      Consumer<Message<SampleDto>> { message ->
        run {
          logger.info(
              "Sample {} with id {} processed", message.payload, message.headers[KafkaHeaders.RECEIVED_KEY])
        }
      }
}
