package com.sample.entrypoint.rest

import com.sample.core.CreateUseCase
import jakarta.inject.Named
import jakarta.ws.rs.Consumes
import jakarta.ws.rs.POST
import jakarta.ws.rs.Path
import jakarta.ws.rs.Produces
import jakarta.ws.rs.core.MediaType
import jakarta.ws.rs.core.Response
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import java.net.URI

@Path("/v1")
class RestController(
  @Named("mongodbCreateUseCase") private val createUseCase: CreateUseCase
) {

  private val logger: Logger = LoggerFactory.getLogger(RestController::class.java)

  @POST
  @Consumes(MediaType.APPLICATION_JSON)
  @Produces(MediaType.APPLICATION_JSON)
  fun create(dto: SampleCreateDto): Response {
    logger.info("Create received")
    val id = createUseCase.create(dto.toDomain()).id
    return Response.created(URI.create("/v1/${id.value}")).build()
  }
}
