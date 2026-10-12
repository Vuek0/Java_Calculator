package com.vuek0.calculator;

public class Calculator {
    private static final int ZERO_DIVISOR = 0;
    private static final String ZERO_DIVIDE_ERROR_MESSAGE = "Ошибка: деление на ноль";

    public static int calculate(int num1, int num2, String operator){
        return switch(operator){
            case "+" -> num1 + num2;
            case "-" -> num1 - num2;
            case "*" -> num1 * num2;
            case "/" -> {
                if(num2 == ZERO_DIVISOR) {
                    throw new IllegalArgumentException(ZERO_DIVIDE_ERROR_MESSAGE);
                }
                yield num1 / num2;
            }
            default -> throw new IllegalArgumentException("Неизвестный оператор: " + operator);
        };
    }
}
