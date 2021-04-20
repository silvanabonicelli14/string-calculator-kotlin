package com.cgm.stringcalculator

object Constants {
    const val CUSTOM_SEPARATOR_START_FROM = "//"
    const val LINE_SEPARATOR = "\n"
    const val MAX_VALUE_ALLOWED = 1000
    const val CUSTOM_SEPARATOR_PREFIX = "["
    const val CUSTOM_SEPARATOR_POSTFIX = "]"
    const val SEPARATOR_OF_SEPARATORS = "$CUSTOM_SEPARATOR_POSTFIX$CUSTOM_SEPARATOR_PREFIX"
    var defaultSeparatorsList = mutableListOf("\n",",")
}

fun getValueFromCommandLine(context: String): String? {
    println("Insert value of $context")
    return readLine()
}
