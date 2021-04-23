package com.cgm.stringcalculator

import com.cgm.stringcalculator.Constants.CUSTOM_SEPARATOR_START_FROM
import com.cgm.stringcalculator.Constants.LINE_SEPARATOR
import com.cgm.stringcalculator.Constants.MAX_VALUE_ALLOWED
import com.cgm.stringcalculator.Constants.SEPARATOR_OF_SEPARATORS
import com.cgm.stringcalculator.Constants.CUSTOM_SEPARATOR_SUFFIFIX
import com.cgm.stringcalculator.Constants.CUSTOM_SEPARATOR_PREFIX
import com.cgm.stringcalculator.Constants.defaultSeparatorsList
import java.lang.IllegalArgumentException

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
        separatorsList = defaultSeparatorsList

        if (inputString.startsWith(CUSTOM_SEPARATOR_START_FROM)) {
            getSeparatorsLine(inputString).split(SEPARATOR_OF_SEPARATORS).apply {separatorsList += this}
            numbersLine = inputString.substring(inputString.indexOf(LINE_SEPARATOR) + 1, inputString.length)
        }
    }

    private fun getListOfNumbers(){
        listOfNumbers = numbersLine.split(*separatorsList) as MutableList<String>
    }

    private fun getSeparatorsLine(inputString: String) : String {
        return inputString
            .substring(CUSTOM_SEPARATOR_START_FROM.length, inputString.indexOf(LINE_SEPARATOR))
            .removeSurrounding(CUSTOM_SEPARATOR_PREFIX,CUSTOM_SEPARATOR_SUFFIFIX)
    }

    private fun getListOfNegativeNumbers() {
        listOfNumbers.forEach { if (it.toInt() < 0) listOfNegativeNumbers += it }
    }

    private fun calculateSum(): Int {
        listOfNegativeNumbers.takeIf { it ->
            if (it.isNotEmpty()) throw IllegalArgumentException("negatives not allowed: $it")
            return listOfNumbers.filter{it.toInt() <= MAX_VALUE_ALLOWED}.sumBy{it.toInt()}
        }
    }
}