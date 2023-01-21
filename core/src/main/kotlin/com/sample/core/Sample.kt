package com.sample.core

import com.sample.core.vo.Audit
import com.sample.core.vo.CellPhone
import com.sample.core.vo.Email
import com.sample.core.vo.Id
import com.sample.core.vo.Name

data class Sample(
    val id: Id,
    val name: Name,
    val email: Email,
    val cellPhone: CellPhone,
    val audit: Audit
)