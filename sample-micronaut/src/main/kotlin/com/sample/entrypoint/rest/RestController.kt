package com.sample.entrypoint.rest

import com.sample.core.CreateUseCase
import io.micronaut.http.HttpResponse
import io.micronaut.http.annotation.Body
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Post
import jakarta.inject.Named
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import java.net.URI

@Controller("/v1")
class RestController(
    @Named("mongodbCreateUseCase") private val createUseCase: CreateUseCase
) {

    private val logger: Logger = LoggerFactory.getLogger(Controller::class.java)

    @Post
    fun create(@Body dto: SampleCreateDto): HttpResponse<Void> {
        logger.info("Create received")
        val id = createUseCase.create(dto.toDomain()).id
        return HttpResponse.created(URI.create("/v1/${id.value}"))
    }
}