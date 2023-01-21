package com.sample.infrastructure.mongodb

import com.sample.core.Sample
import com.sample.core.vo.Audit
import com.sample.core.vo.CellPhone
import com.sample.core.vo.Email
import com.sample.core.vo.Id
import com.sample.core.vo.Name
import java.util.*

fun Sample.toEntity(): SampleEntity = SampleEntity(
    id = id.value,
    name = name.value,
    cellPhone = cellPhone.value,
    email = email.value,
    createdAt = Date.from(audit.createdAt),
    updatedAt = Date.from(audit.updatedAt),
    externalId = id.external
)

fun SampleEntity.toDomain(): Sample = Sample(
    id = Id(this.id),
    name = Name(this.name),
    cellPhone = CellPhone(this.cellPhone),
    email = Email(this.email),
    audit = Audit(this.createdAt.toInstant(), this.updatedAt.toInstant())
)