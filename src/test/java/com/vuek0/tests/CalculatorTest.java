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
        assertEquals(8.0, result, 0.001);

    }

    @Test
    void shouldMinus() {
        int result = Calculator.calculate(10, 5, "-");
        assertEquals(5.0, result, 0.001);
    }

    @Test
    void shouldMultiply() {
        int result = Calculator.calculate(5, 3, "*");
        assertEquals(15.0, result, 0.001);

    }

    @Test
    void shouldDivide() {
        int result = Calculator.calculate(10, 5, "/");
        assertEquals(2, result, 0.001);
    }

    // Exceptions tests
    @Test
    void divisionByZeroExpectException() {

        assertThrows(IllegalArgumentException.class,
                () -> Calculator.calculate(5, 0, "/"));
    }
}
