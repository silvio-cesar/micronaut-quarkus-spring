package com.sample.entrypoint.kafka.external

import io.quarkus.runtime.annotations.RegisterForReflection

@RegisterForReflection
data class ExternalSampleDto constructor(
  val name: String,
  val cellPhone: String,
  val email: String
)