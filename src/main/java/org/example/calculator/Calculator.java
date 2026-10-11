package org.example.calculator;

public class Calculator {
    private static final int ZERO_DIVISOR = 0;

    public static int calculate(int num1, int num2, String operator){
        return switch(operator){
            case "+" -> num1 + num2;
            case "-" -> num1 - num2;
            case "*" -> num1 * num2;
            case "/" -> {
                if(num2 == ZERO_DIVISOR) throw new IllegalArgumentException("Ошибка: деление на ноль");
                yield num1 / num2;
            }
            default -> throw new IllegalArgumentException("Неизвестный оператор: " + operator);
        };
    }
}
