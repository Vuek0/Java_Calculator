package com.vuek0;

import java.util.Scanner;

import com.vuek0.calculator.Calculator;
import com.vuek0.tests.CalculatorTests;

public class Main {

    private static final int MAX_ELEMENTS_IN_EXPRESSION = 3;

    public static void main(String[] args) {
        CalculatorTests.runTests();

        Scanner scanner = new Scanner(System.in);
        System.out.println("Это калькулятор! Вводить выражения в виде: число оператор число\n" +
                "Для того чтобы выйти из программы напишите 'exit'");
        while(true) {
            System.out.print("Введите выражение: ");
            String expression = scanner.nextLine();
            if(expression.trim().equals("exit")) break;

            String[] elements = expression.split(" ");
            if(elements.length != MAX_ELEMENTS_IN_EXPRESSION) {
                System.out.println("Ошибка: неверный формат. Используйте: число оператор число");
                continue;
            }
            try {
                int num1 = Integer.parseInt(elements[0]);
                int num2 = Integer.parseInt(elements[2]);
                String operator = elements[1];

                int result = Calculator.calculate(num1, num2, operator);
                System.out.printf("%s = %d%n", expression, result);
            } catch (NumberFormatException error) {
                System.out.println("Ошибка: неверный формат. Используйте: число оператор число");
            } catch (IllegalArgumentException error) {
                System.out.println(error.getMessage());
            }

        }
        scanner.close();
    }


}