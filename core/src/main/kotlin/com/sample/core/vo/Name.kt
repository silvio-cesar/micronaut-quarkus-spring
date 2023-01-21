package com.sample.core.vo

data class Name(
    val value: String
) {
    init {
        if (value.isBlank()) throw Exception("Empty name")
    }
}