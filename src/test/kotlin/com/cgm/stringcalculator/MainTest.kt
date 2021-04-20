package com.cgm.stringcalculator

import org.junit.jupiter.api.Test
import org.junit.Assert.assertEquals
import org.junit.jupiter.api.assertThrows
import java.lang.Exception

class MainTest {
    @Test
    fun `empty string return zero`() {
        assertEquals(0,StringCalculator().add(""))
    }

    @Test
    fun `one number return number`() {
        assertEquals(1,StringCalculator().add("1"))
    }

    @Test
    fun `two numbers return sum of two numbers`() {
        assertEquals(3,StringCalculator().add("1,2"))
    }

    @Test
    fun `numbers return sum of all numbers`() {
        assertEquals(10,StringCalculator().add("1,2,3,4"))
    }

    @Test
    fun `add numbers with newLine between numbers return sum of numbers`() {
        assertEquals(10,StringCalculator().add("1\n2,3,4"))
    }

    @Test
    fun `numbers with special separator return sum of numbers`() {
        assertEquals(6,StringCalculator().add("//;\n1;2;3"))
    }
    @Test
    fun `numbers with special separator in square brackets return sum of numbers`() {
        assertEquals(6,StringCalculator().add("//[;]\n1;2;3"))
    }

    @Test
    fun `numbers with special separator and new line return sum of numbers`() {
        assertEquals(6,StringCalculator().add("//;\n1\n2;3"))
    }

    @Test
    fun `negative numbers throw exception`() {
        val exception = assertThrows<Exception>{StringCalculator().add("1,2,-3,-4")}
        assertEquals("negatives not allowed: -3-4", exception.message)
    }
    @Test
    fun `negative numbers and special separator throw exception`() {
        val exception = assertThrows<Exception>{StringCalculator().add("//;\n1;2;-3;-4")}
        assertEquals("negatives not allowed: -3-4", exception.message)
    }

    @Test
    fun `negative numbers and special separator with square brackets throw exception`() {
        val exception = assertThrows<Exception>{StringCalculator().add("//[;]\n1;2;-3;-4")}
        assertEquals("negatives not allowed: -3-4", exception.message)
    }

    @Test
    fun `numbers equal to 1000 do sum`() {
        assertEquals(1005,StringCalculator().add("//;\n1000;2;3"))
    }

    @Test
    fun `numbers greater than 1000 ignore and sum the others`() {
        assertEquals(5,StringCalculator().add("//;\n1001;2;3"))
    }

    @Test
    fun `with len separator greater than 1 return sum of numbers`() {
        assertEquals(3,StringCalculator().add("//[##]\n1##2"))
    }

    @Test
    fun `one separator return sum of numbers`() {
        assertEquals(6,StringCalculator().add("//[@]\n1@2@3"))
    }

    @Test
    fun `one more separator return sum of numbers`() {
        assertEquals(6,StringCalculator().add("//[@][#]\n1#2@3"))
    }

    @Test
    fun `one more separator with length greater than one return sum of numbers`() {
        assertEquals(10,StringCalculator().add("//[@@][!##][;]\n1!##2@@3;4"))
    }

    @Test
    fun `custom separator equal to line separator indicator return sum of numbers`() {
        // ho specificato un separatore custom "//" esattamente uguale all'indicatore di inizio riga separatori "//"
        assertEquals(10,StringCalculator().add("//[//][@@][!##][;]\n1//2@@3;4"))
    }
}