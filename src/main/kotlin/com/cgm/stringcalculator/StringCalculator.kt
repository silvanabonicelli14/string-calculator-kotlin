package com.cgm.stringcalculator

class StringCalculator {
    fun add(numbers: String): Int {
        var charToSplit = ","
        var stringListInputNumbers = numbers
        var stringListOfNegativeNumbers = ""

        if (numbers.isEmpty()) return 0

        if (numbers.startsWith("//")){
            charToSplit = numbers.substring(2,3)
            stringListInputNumbers = numbers.substring(4,numbers.length)
        }
        val listOfNumbers = stringListInputNumbers.replace("\n",charToSplit).split(charToSplit)

        listOfNumbers.forEach{ if (it.toInt() < 0) stringListOfNegativeNumbers += it}

        if(stringListOfNegativeNumbers.isNotEmpty())
            throw Exception("negatives not allowed: $stringListOfNegativeNumbers")

        return listOfNumbers.sumBy{it.toInt()}
    }
}