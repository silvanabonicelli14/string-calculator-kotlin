package com.cgm.stringcalculator

object Constants {
    const val CUSTOM_SEPARATOR_START_FROM = "//"
    const val LINE_SEPARATOR = "\n"
    const val MAX_VALUE_ALLOWED = 1000
    const val CUSTOM_SEPARATOR_PREFIX = "["
    const val CUSTOM_SEPARATOR_SUFFIFIX = "]"
    const val SEPARATOR_OF_SEPARATORS = "$CUSTOM_SEPARATOR_SUFFIFIX$CUSTOM_SEPARATOR_PREFIX"
    var defaultSeparatorsList = arrayOf("\n",",")
}

fun getValueFromCommandLine(context: String): String? {
    println("Insert value of $context")
    return readLine()
}
