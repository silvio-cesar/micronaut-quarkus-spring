package com.sample.core.vo

data class Email(
    val value: String,
) {
    init {
        if (value.length < 5 || value.length > 50) throw Exception("Invalid email size")
    }
}