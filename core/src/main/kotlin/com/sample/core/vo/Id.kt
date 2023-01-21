package com.sample.core.vo

import java.util.UUID

data class Id(
    val value: String = UUID.randomUUID().toString(),
    val external: String = ""
) {
    override fun toString(): String = value
}