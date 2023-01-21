package com.sample.core.vo

import java.time.Instant

data class Audit(
    val createdAt: Instant,
    var updatedAt: Instant
) {
    constructor(): this(Instant.now(), Instant.now())
}