package com.sample.config

import com.sample.constant.KafkaConstant
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.kafka.support.DefaultKafkaHeaderMapper
import org.springframework.kafka.support.KafkaHeaderMapper

@Configuration
class KafkaConfig {

    @Bean
    fun defaultKafkaHeaderMapper(): KafkaHeaderMapper {
        val mapper = DefaultKafkaHeaderMapper()
        mapper.setRawMappedHeaders(mutableMapOf(KafkaConstant.OPERATION_HEADER to true))
        return mapper
    }
}