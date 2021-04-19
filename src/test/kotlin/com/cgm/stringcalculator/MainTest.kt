package com.cgm.stringcalculator

import org.junit.jupiter.api.Test
import org.junit.Assert

class MainTest {
    @Test
    fun add_emptyString_ReturnZero() {
        Assert.assertEquals(0,StringCalculator().add(""))
    }
    @Test
    fun add_one_number_ReturnNumber() {
        Assert.assertEquals(1,StringCalculator().add("1"))
    }
    @Test
    fun add_two_numbers_ReturnSumOfTwoNumbers() {
        Assert.assertEquals(3,StringCalculator().add("1,2"))
    }
    @Test
    fun add_numbers_ReturnNumbers() {
        Assert.assertEquals(10,StringCalculator().add("1,2,3,4"))
    }
}