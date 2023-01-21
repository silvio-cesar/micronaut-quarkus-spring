package com.sample.core.utils

fun String.isNumeric(): Boolean = this.all { char -> char.isDigit() }