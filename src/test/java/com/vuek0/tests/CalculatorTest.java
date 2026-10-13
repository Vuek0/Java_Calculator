package com.vuek0.tests;

import com.vuek0.calculator.Calculator;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CalculatorTest {

    // Correct values tests
    @Test
    void shouldPlus() {
        int result = Calculator.calculate(5, 3, "+");
        assertEquals(8, result);
    }

    @Test
    void shouldMinus() {
        int result = Calculator.calculate(10, 5, "-");
        assertEquals(5, result);
    }

    @Test
    void shouldMultiply() {
        int result = Calculator.calculate(5, 3, "*");
        assertEquals(15, result);
    }

    @Test
    void shouldDivide() {
        int result = Calculator.calculate(10, 5, "/");
        assertEquals(2, result);
    }

    // Exceptions tests
    @Test
    void divisionByZeroExpectException() {
        assertThrows(ArithmeticException.class,
                () -> Calculator.calculate(5, 0, "/"));
    }
}
