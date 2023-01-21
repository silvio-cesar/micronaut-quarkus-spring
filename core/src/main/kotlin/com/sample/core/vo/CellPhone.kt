package com.sample.core.vo

import com.sample.core.utils.isNumeric

data class CellPhone (
    val value: String
) {
    init {
        if (!value.isNumeric()) throw Exception("Number not numeric")
        if (value.length < 12 || value.length >13) throw Exception("Number invalid size")
    }
}