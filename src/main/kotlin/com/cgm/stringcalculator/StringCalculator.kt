package com.cgm.stringcalculator

import com.cgm.stringcalculator.Constants.CUSTOM_SEPARATOR_START_FROM
import com.cgm.stringcalculator.Constants.DEFAULT_SEPARATOR
import com.cgm.stringcalculator.Constants.LINE_SEPARATOR
import com.cgm.stringcalculator.Constants.SPECIAL_CHAR_ALLOWED


class StringCalculator {

    fun add(numbers: String): Int {
        if (numbers.isNullOrEmpty()) return 0

        val listOfNumbers = getListFromInputLine(numbers,getInputCharSeparator(numbers))

        checkForNegativeNumbers(listOfNumbers)

        return listOfNumbers.sumBy{it.toInt()}
    }

    private fun checkForNegativeNumbers(listOfNumbers: List<String>) {

        var stringListOfNegativeNumbers = ""
        listOfNumbers.forEach { if (it.toInt() < 0) stringListOfNegativeNumbers += it }

        if (stringListOfNegativeNumbers.isNotEmpty())
            throw Exception("negatives not allowed: $stringListOfNegativeNumbers")
    }

    private fun getInputCharSeparator(inputString: String):String{
        return if (inputString.startsWith(CUSTOM_SEPARATOR_START_FROM))
                   inputString.substring(CUSTOM_SEPARATOR_START_FROM.length,CUSTOM_SEPARATOR_START_FROM.length+1)
               else DEFAULT_SEPARATOR
    }

    private fun getListFromInputLine(inputString: String, separatorChar: String) : List<String>{
        val stringListInputNumbers =
            if (inputString.startsWith(CUSTOM_SEPARATOR_START_FROM)) inputString.substring(inputString.indexOf(LINE_SEPARATOR) +1,inputString.length)
            else inputString

        return stringListInputNumbers.replace(SPECIAL_CHAR_ALLOWED,separatorChar).split(separatorChar)
    }
}