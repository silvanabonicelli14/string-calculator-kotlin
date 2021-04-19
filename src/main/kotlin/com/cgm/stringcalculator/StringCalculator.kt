package com.cgm.stringcalculator

class StringCalculator {
    fun add(numbers: String): Int {
        var charToSplit = ","
        var listOfNumbers = numbers

        if (numbers.startsWith("//")){
            charToSplit = numbers.substring(2,3)
            listOfNumbers = numbers.substring(4,numbers.length)
        }

        return if (numbers.isNullOrEmpty()) 0
               else listOfNumbers.replace("\n",charToSplit).split(charToSplit).sumBy{it.toInt()}
    }

//    fun add(numbers: String): Int {
//        var charToSplit = ","
//        var listOfNumbers = numbers
//
//        if (numbers.startsWith("//")){
//            charToSplit = numbers.substring(2,3)
//            listOfNumbers = numbers.substring(4,numbers.length)
//        }
//
//        return if (numbers.isNullOrEmpty()) 0
//        else listOfNumbers.replace("\n",charToSplit).split(charToSplit).sumBy{it.toInt()}
//    }
}