package com.cgm.stringcalculator

class StringCalculator {
    fun add(numbers: String): Int {
        val charToSplit = ","
        return if (numbers.isNullOrEmpty()) 0
               else numbers.replace("\n",charToSplit).split(charToSplit).sumBy{it.toInt()}
    }
}


