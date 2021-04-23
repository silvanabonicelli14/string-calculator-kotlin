package com.cgm.stringcalculator

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import java.lang.Exception

class MainTest {
    @ParameterizedTest(name = "add function should return {1} for {0}")
    @MethodSource("sumNumbersArguments")
    fun `string of numbers return sum of numbers`(inputString: String,expectedSum: Int ) {
        assertEquals(expectedSum,StringCalculator().add(inputString))
    }

    @ParameterizedTest(name = "add function should return {1} for {0}")
    @MethodSource("sumWithNewLineTestArguments")
    fun `string of numbers with newline char between numbers return sum of numbers`(inputString: String,expectedSum: Int ) {
        assertEquals(expectedSum,StringCalculator().add(inputString))
    }

    @ParameterizedTest(name = "add function should return {1} for {0}")
    @MethodSource("sumWithCustomSeparatorsArguments")
    fun `numbers with custom separators return sum of numbers`(inputString: String,expectedSum: Int ) {
        assertEquals(expectedSum,StringCalculator().add(inputString))
    }

    @ParameterizedTest(name = "add function should return {1} for {0}")
    @MethodSource("sumWithNegativeArguments")
    fun `negative numbers throw exception`(inputString: String,expectedException: String ) {
        val exception = assertThrows<Exception>{StringCalculator().add(inputString)}
        assertEquals(expectedException, exception.message)
    }

    @Test
    fun `numbers equal to 1000 are summed`() {
        assertEquals(1005,StringCalculator().add("//;\n1000;2;3"))
    }

    @Test
    fun `numbers greater than 1000 are ignored and fun sum the others`() {
        assertEquals(5,StringCalculator().add("//;\n1001;2;3"))
    }

    companion object {
        @JvmStatic
        fun sumNumbersArguments(): List<Arguments> =
            listOf(
                Arguments.of("", 0),
                Arguments.of("1", 1),
                Arguments.of("1,2", 3),
                Arguments.of("1,2,3,4", 10)
            )

        @JvmStatic
        fun sumWithNewLineTestArguments(): List<Arguments> =
            listOf(
                Arguments.of("1\n2,3,4", 10),
                Arguments.of("1\n2\n3,4", 10)
            )

        @JvmStatic
        fun sumWithCustomSeparatorsArguments(): List<Arguments> =
            listOf(
                Arguments.of("//;\n1;2;3", 6),
                Arguments.of("//[\n1[2[3", 6),
                Arguments.of("//]\n1]2]3", 6),
                Arguments.of("//[;]\n1;2;3", 6),
                Arguments.of("//;\n1\n2;3", 6),
                Arguments.of("//[##]\n1##2", 3),
                Arguments.of("//[@]\n1@2@3", 6),
                Arguments.of("//[@][*]\n1*2@3", 6),
                Arguments.of("//[@][*]\n1\n2@3", 6),
                Arguments.of("//[@@][!##][;]\n1!##2@@3;4", 10),
                Arguments.of("//[//][@@][!##][;]\n1//2@@3;4", 10), // ho specificato un separatore custom "//" esattamente uguale all'indicatore di inizio riga separatori "//"
                Arguments.of("//[//][*][12][;]\n1//2123;4", 10) //ho specificato caratteri speciali e numeri come separatori
            )

        @JvmStatic
        fun sumWithNegativeArguments(): List<Arguments> =
            listOf(
                Arguments.of("1,2,-3,-4", "negatives not allowed: -3-4"),
                Arguments.of("//;\n1;2;-3;-4", "negatives not allowed: -3-4"),
                Arguments.of("//[;]\n1;2;-3;-4", "negatives not allowed: -3-4"),
                Arguments.of("//[##]\n1\n2##-3##-4", "negatives not allowed: -3-4")
            )
    }
}