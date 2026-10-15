package com.vuek0.tests;

import com.vuek0.calculator.Calculator;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CalculatorTest {

    // Correct values tests
    @Test
    void shouldPlus() {
        double result = Calculator.calculate(5, 3, "+");
        assertEquals(8.0, result, 0.001);
    }

    @Test
    void shouldMinus() {
        double result = Calculator.calculate(10, 5, "-");
        assertEquals(5.0, result, 0.001);
    }

    @Test
    void shouldMultiply() {
        double result = Calculator.calculate(5, 3, "*");
        assertEquals(15.0, result, 0.001);
    }

    @Test
    void shouldDivide() {
        double result = Calculator.calculate(10, 5, "/");
        assertEquals(2.0, result, 0.001);
    }

    // Exceptions tests
    @Test
    void divisionByZeroExpectException() {
        assertThrows(ArithmeticException.class,
                () -> Calculator.calculate(5.0, 0.0, "/"));
    }
}
