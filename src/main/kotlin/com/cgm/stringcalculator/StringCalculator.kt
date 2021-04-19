package com.cgm.stringcalculator

class StringCalculator {
    fun add(numbers: String): Int {
        if (numbers.isNullOrEmpty()) return 0
        val listOfNumbers = numbers?.split(",").toTypedArray()
        if (listOfNumbers.size == 1) return listOfNumbers[0].toInt()
        return listOfNumbers[0].toInt() + listOfNumbers[1].toInt()
    }
}


