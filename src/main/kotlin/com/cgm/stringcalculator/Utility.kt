package com.cgm.stringcalculator

object Constants {
    const val DEFAULT_SEPARATOR = ","
    const val CUSTOM_SEPARATOR_START_FROM = "//"
    const val LINE_SEPARATOR = "\n"
    const val SPECIAL_CHAR_ALLOWED = "\n"
    const val MAX_VALUE_ALLOWED = 1000
}

fun getValueFromCommandLine(context: String): String? {
    println("Insert value of $context")
    return readLine()
}