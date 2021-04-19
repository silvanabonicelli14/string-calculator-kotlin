package com.cgm.stringcalculator

import com.cgm.stringcalculator.Constants.CUSTOM_SEPARATOR_START_FROM
import com.cgm.stringcalculator.Constants.DEFAULT_SEPARATOR
import com.cgm.stringcalculator.Constants.LINE_SEPARATOR
import com.cgm.stringcalculator.Constants.MAX_VALUE_ALLOWED
import com.cgm.stringcalculator.Constants.SPECIAL_CHAR_ALLOWED


class StringCalculator {

    fun add(numbers: String): Int {
        if (numbers.isNullOrEmpty()) return 0

        val listOfNumbers = getListFromInputLine(numbers,getInputCharSeparators(numbers))

        checkForNegativeNumbers(listOfNumbers)

        return listOfNumbers.filter{it.toInt() <= MAX_VALUE_ALLOWED}.sumBy{it.toInt()}
    }

    private fun checkForNegativeNumbers(listOfNumbers: List<String>) {

        var stringListOfNegativeNumbers = ""
        listOfNumbers.forEach { if (it.toInt() < 0) stringListOfNegativeNumbers += it }

        if (stringListOfNegativeNumbers.isNotEmpty())
            throw Exception("negatives not allowed: $stringListOfNegativeNumbers")
    }

    private fun getInputCharSeparators(inputString: String):List<String>{
        var listOfSeparators = mutableListOf<String>()
        if (inputString.startsWith(CUSTOM_SEPARATOR_START_FROM))
        {
            val separatorLine = inputString.substring(CUSTOM_SEPARATOR_START_FROM.length,inputString.indexOf(LINE_SEPARATOR))
            listOfSeparators = separatorLine.split("][") as MutableList<String>
        }
        else listOfSeparators.add(DEFAULT_SEPARATOR)
        return listOfSeparators

    }

    private fun getListFromInputLine(inputString: String, separatorChar: List<String>) : List<String>{
        val stringListInputNumbers =
            if (inputString.startsWith(CUSTOM_SEPARATOR_START_FROM)) inputString.substring(inputString.indexOf(LINE_SEPARATOR) +1,inputString.length)
            else inputString

        val stringSeparator = separatorChar.joinToString("|",).replace("[","").replace("]","")

        return stringListInputNumbers.replace(SPECIAL_CHAR_ALLOWED, separatorChar[0]).split(stringSeparator.toRegex())
    }
}