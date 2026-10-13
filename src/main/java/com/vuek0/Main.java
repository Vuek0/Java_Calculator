package com.vuek0;

import java.util.Scanner;

import com.vuek0.calculator.Calculator;

public class Main {

    private static final String HELLO_CALCULATOR_MESSAGE = "Это калькулятор! Вводить выражения в виде: число оператор число\n" +
            "Для того чтобы выйти из программы напишите 'exit'";
    private static final int MAX_ELEMENTS_IN_EXPRESSION = 3;
    private static final String PROGRAM_EXIT_COMMAND = "exit";
    private static final String INVALID_FORMAT_MESSAGE = "Ошибка: неверный формат. Используйте: число оператор число";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println(HELLO_CALCULATOR_MESSAGE);
        while(true) {
            System.out.print("Введите выражение: ");
            String expression = scanner.nextLine();
            if(expression.trim().equalsIgnoreCase(PROGRAM_EXIT_COMMAND)) break;

            String[] elements = expression.split(" ");
            if(elements.length != MAX_ELEMENTS_IN_EXPRESSION) {
                System.out.println(INVALID_FORMAT_MESSAGE);
                continue;
            }
            try {
                int num1 = Integer.parseInt(elements[0]);
                int num2 = Integer.parseInt(elements[2]);
                String operator = elements[1];

                int result = Calculator.calculate(num1, num2, operator);
                System.out.printf("%s = %d%n", expression, result);
            } catch (NumberFormatException error) {
                System.out.println(INVALID_FORMAT_MESSAGE);
            } catch (ArithmeticException | IllegalArgumentException error) {
                System.out.println(error.getMessage());
            }

        }
        scanner.close();
    }


}