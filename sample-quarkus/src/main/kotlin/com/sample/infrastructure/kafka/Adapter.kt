package com.sample.infrastructure.kafka

import com.sample.core.Sample

fun Sample.toDto(): SampleDto = SampleDto(
    id = this.id.value,
    externalId = this.id.external,
    name = this.name.value,
    email = this.email.value,
    cellPhone = this.cellPhone.value,
    createdAt = this.audit.createdAt,
    updatedAt = this.audit.updatedAt
)