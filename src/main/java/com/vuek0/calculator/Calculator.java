package com.vuek0.calculator;

public class Calculator {
    private static final String ZERO_DIVIDE_ERROR_MESSAGE = "Ошибка: деление на ноль";

    public static double calculate(double num1, double num2, String operator){
        return switch(operator){
            case "+" -> num1 + num2;
            case "-" -> num1 - num2;
            case "*" -> num1 * num2;
            case "/" -> {
                if(num2 == 0) {
                    throw new ArithmeticException(ZERO_DIVIDE_ERROR_MESSAGE);
                }
                yield num1 / num2;
            }
            default -> throw new IllegalArgumentException("Неизвестный оператор: " + operator);
        };
    }


}
