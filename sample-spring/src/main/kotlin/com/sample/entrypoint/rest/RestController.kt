package com.sample.entrypoint.rest

import com.sample.core.CreateUseCase
import java.net.URI
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/v1")
class RestController(@Qualifier("mongodbCreateUseCase") private val createUseCase: CreateUseCase) {

  private val logger: Logger = LoggerFactory.getLogger("RestController")

  @PostMapping
  fun create(@RequestBody dto: SampleCreateDto): ResponseEntity<Void> {
    logger.info("Create received")
    val id = createUseCase.create(dto.toDomain()).id
    return ResponseEntity.created(URI.create("/v1/${id.value}")).build()
  }
}
