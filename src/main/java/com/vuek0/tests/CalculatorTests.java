package com.vuek0.tests;

import com.vuek0.calculator.Calculator;
import com.vuek0.testframework.TestFramework;

public class CalculatorTests {
    public static void runTests() {
        System.out.println("--- Тесты ---");
        TestFramework.doTest(() -> Calculator.calculate(5, 3, "+"), 8);
        TestFramework.doTest(() -> Calculator.calculate(5, 2, "/"), 2);
        TestFramework.doTest(() -> Calculator.calculate(10, 3, "-"), 7);
        TestFramework.doTest(() -> Calculator.calculate(4, 6, "*"), 24);
        System.out.println("--- Конец тестов ---\n");
    }
}
