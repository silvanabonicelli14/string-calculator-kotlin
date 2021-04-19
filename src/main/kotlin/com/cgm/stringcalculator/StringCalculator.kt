package com.cgm.stringcalculator

class StringCalculator {
    fun add(numbers: String): Int {
        return if (numbers.isNullOrEmpty()) 0 else numbers.split(",").sumBy{it.toInt()}
    }
}


