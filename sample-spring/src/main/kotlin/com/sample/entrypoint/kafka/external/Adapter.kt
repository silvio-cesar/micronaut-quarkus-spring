package com.sample.entrypoint.kafka.external

import com.sample.core.Sample
import com.sample.core.vo.Audit
import com.sample.core.vo.CellPhone
import com.sample.core.vo.Email
import com.sample.core.vo.Id
import com.sample.core.vo.Name

fun ExternalSampleDto.toDomain(externalId: String): Sample = Sample(
    id = Id(external = externalId),
    name = Name(this.name),
    cellPhone = CellPhone(this.cellPhone),
    email = Email(this.email),
    audit = Audit()
)