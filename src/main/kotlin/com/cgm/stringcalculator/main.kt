package com.cgm.stringcalculator

fun main(args: Array<String>) {
    val inputLines = getValueFromCommandLine("list of numbers").toString()
    print("Sum of entered numbers is: ${StringCalculator().add(inputLines)}")
}