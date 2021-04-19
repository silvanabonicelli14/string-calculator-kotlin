package com.cgm.stringcalculator

import org.junit.jupiter.api.Test
import org.junit.Assert
import org.junit.Assert.assertEquals
import org.junit.jupiter.api.assertThrows
import java.lang.Exception

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
    fun add_numbers_ReturnSumOfNumbers() {
        Assert.assertEquals(10,StringCalculator().add("1,2,3,4"))
    }

    @Test
    fun add_numbers_with_newLine_ReturnSumOfNumbers() {
        Assert.assertEquals(10,StringCalculator().add("1\n2,3,4"))
    }

    @Test
    fun add_numbers_with_special_separator_ReturnSumOfNumbers() {
        Assert.assertEquals(6,StringCalculator().add("//;\n1;2;3"))
    }

    @Test
    fun add_numbers_with_special_separator_and_new_line_ReturnSumOfNumbers() {
        Assert.assertEquals(6,StringCalculator().add("//;\n1\n2;3"))
    }

    @Test
    fun add_with_special_separator_two_numbers_ReturnSumOfTwoNumbers() {
        Assert.assertEquals(3,StringCalculator().add("//;\n1;2"))
    }

    @Test
    fun add_negative_numbers_ThrowException() {
        val exception = assertThrows<Exception>{StringCalculator().add("1,2,-3,-4")}
        assertEquals("negatives not allowed: -3-4", exception.message)
    }
    @Test
    fun add_negative_numbers_and_special_separator_ThrowException() {
        val exception = assertThrows<Exception>{StringCalculator().add("//;\n1;2;-3;-4")}
        assertEquals("negatives not allowed: -3-4", exception.message)
    }

//    @Test
//    fun add_numbers_with_newLineaftercomma_ReturnSumOfNumbers() {
//        Assert.assertEquals(10,StringCalculator().add("1,2,3\n,4"))
//    }

//    @Test
//    fun add_numbers_with_notValidChar_ThrowException() {
//        assertThrows<IllegalStateException>{StringCalculator().add("1,\n")}
//    }
}