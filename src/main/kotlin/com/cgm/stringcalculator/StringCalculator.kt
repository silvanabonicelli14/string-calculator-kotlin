package com.cgm.stringcalculator

import com.cgm.stringcalculator.Constants.CUSTOM_SEPARATOR_START_FROM
import com.cgm.stringcalculator.Constants.LINE_SEPARATOR
import com.cgm.stringcalculator.Constants.MAX_VALUE_ALLOWED
import com.cgm.stringcalculator.Constants.SEPARATOR_OF_SEPARATORS
import com.cgm.stringcalculator.Constants.CUSTOM_SEPARATOR_POSTFIX
import com.cgm.stringcalculator.Constants.CUSTOM_SEPARATOR_PREFIX
import com.cgm.stringcalculator.Constants.defaultSeparatorsList

class StringCalculator  {
    private var numbersLine: String = ""
    private var listOfNegativeNumbers = ""
    private var separatorsList =  mutableListOf<String>()

    fun add(inputString: String): Int {
        if (inputString.isEmpty()) return 0

        initLines(inputString)

        var listOfNumbers = getListOfNumbers()

        checkForNegativeNumbers(listOfNumbers)

        return calculateSum(listOfNumbers)
    }

    private fun initLines(inputString: String) {
        numbersLine = inputString
        separatorsList = defaultSeparatorsList

        if (inputString.startsWith(CUSTOM_SEPARATOR_START_FROM)) {
            inputString
                .substring(CUSTOM_SEPARATOR_START_FROM.length, inputString.indexOf(LINE_SEPARATOR))
                .let{it.split(SEPARATOR_OF_SEPARATORS).toMutableList().apply {separatorsList.addAll(this)}}

            numbersLine = inputString.substring(inputString.indexOf(LINE_SEPARATOR) + 1, inputString.length)
        }
    }

    private fun checkForNegativeNumbers(listOfNumbers: List<String>) {
        listOfNumbers.forEach { if (it.toInt() < 0) listOfNegativeNumbers += it }
        listOfNegativeNumbers.apply {if (this.isNotEmpty()) throw Exception("negatives not allowed: $this")}
    }

    private fun calculateSum(listOfNumbers: List<String>): Int {
        return listOfNumbers.filter{it.toInt() <= MAX_VALUE_ALLOWED}.sumBy{it.toInt()}
    }

    private fun getListOfNumbers(): List<String> {
        var arrayOfSeparators = arrayOf<String>()
        separatorsList.indices.forEach { i ->
            arrayOfSeparators += separatorsList[i].replace(CUSTOM_SEPARATOR_POSTFIX, "").replace(CUSTOM_SEPARATOR_PREFIX, "")
        }.apply { return numbersLine.split(*arrayOfSeparators) }
    }
}