package com.cgm.stringcalculator

import com.cgm.stringcalculator.Constants.CUSTOM_SEPARATOR_START_FROM
import com.cgm.stringcalculator.Constants.LINE_SEPARATOR
import com.cgm.stringcalculator.Constants.MAX_VALUE_ALLOWED
import com.cgm.stringcalculator.Constants.SEPARATOR_OF_SEPARATORS
import com.cgm.stringcalculator.Constants.CUSTOM_SEPARATOR_SUFFIFIX
import com.cgm.stringcalculator.Constants.CUSTOM_SEPARATOR_PREFIX
import com.cgm.stringcalculator.Constants.defaultSeparatorsList

class StringCalculator  {
    private var numbersLine: String = ""
    private var listOfNegativeNumbers = ""
    private var separatorsList =  arrayOf<String>()
    private var listOfNumbers =  mutableListOf<String>()

    fun add(inputString: String): Int {
        if (inputString.isEmpty()) return 0
        initLines(inputString)
        getListOfNumbers()
        getListOfNegativeNumbers()

        return calculateSum()
    }

    private fun initLines(inputString: String) {
        numbersLine = inputString

        if (inputString.startsWith(CUSTOM_SEPARATOR_START_FROM)) {
            getSeparatorsLine(inputString).split(SEPARATOR_OF_SEPARATORS).apply {separatorsList += this}
            numbersLine = inputString.substring(inputString.indexOf(LINE_SEPARATOR) + 1, inputString.length)
        }
        separatorsList += defaultSeparatorsList
    }

    private fun getListOfNumbers(){
        listOfNumbers = numbersLine.split(*separatorsList) as MutableList<String>
    }

    private fun getSeparatorsLine(inputString: String) : String {
        return inputString
            .substring(CUSTOM_SEPARATOR_START_FROM.length, inputString.indexOf(LINE_SEPARATOR))
            .removePrefix(CUSTOM_SEPARATOR_PREFIX)
            .removeSuffix(CUSTOM_SEPARATOR_SUFFIFIX)
    }

    private fun getListOfNegativeNumbers() {
        listOfNumbers.forEach { if (it.toInt() < 0) listOfNegativeNumbers += it }
    }

    private fun calculateSum(): Int {
        listOfNegativeNumbers.apply {
            if (this.isNotEmpty()) throw Exception("negatives not allowed: $this")
            return listOfNumbers.filter{it.toInt() <= MAX_VALUE_ALLOWED}.sumBy{it.toInt()}
        }
    }
}