package com.vuek0;

import java.util.ArrayList;
import java.util.Optional;
import java.util.Scanner;

import com.vuek0.calculator.Calculator;
import com.vuek0.calculator.HistoryManager;

public class Main {

    private static final String HELLO_CALCULATOR_MESSAGE = "Это калькулятор! Вводить выражения в виде: число оператор число\n" +
            "Для того чтобы выйти из программы напишите 'exit'";
    private static final int MAX_ELEMENTS_IN_EXPRESSION = 3;
    private static final String PROGRAM_EXIT_COMMAND = "exit";
    private static final String PROGRAM_HISTORY_COMMAND = "history";
    private static final String PROGRAM_CLEAR_HISTORY_COMMAND = "clear";
    private static final String PROGRAM_LAST_OPERATION_COMMAND = "last";
    private static final String PROGRAM_HELP_COMMAND = "help";
    private static final String INVALID_FORMAT_MESSAGE = "Ошибка: неверный формат. Используйте: число оператор число";

    private static boolean checkCommand(String expression, String command){
        return expression.trim().equalsIgnoreCase(command);
    }

    private static void printHistory(HistoryManager history) {
        ArrayList<String> operations = history.getAllOperations();
        if (operations.isEmpty()) {
            System.out.println("История пуста!");
            return;
        }
        for (int i = 0; i < operations.size(); i++){
            System.out.printf("%d) %s%n", i + 1, operations.get(i));
        }
    }

    private static void printHelp(){
        System.out.println("""
                Доступные команды:
                
                <число> <оператор> <число>
                
                Операторы:
                +  сложение
                -  вычитание
                *  умножение
                /  деление
                
                Дополнительные команды:
                history  - показать историю
                last     - повторить последнюю операцию
                clear    - очистить историю
                exit     - выход
                """);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        HistoryManager history = new HistoryManager();

        System.out.println(HELLO_CALCULATOR_MESSAGE);
        while(true) {
            System.out.print("Введите выражение: ");
            String expression = scanner.nextLine();
            if(checkCommand(expression, PROGRAM_EXIT_COMMAND)) break;
            else if(checkCommand(expression, PROGRAM_HISTORY_COMMAND)) {
                printHistory(history);
                continue;
            } else if (checkCommand(expression, PROGRAM_LAST_OPERATION_COMMAND)) {
                Optional<String> lastOperation = history.getLastOperation();
                if(lastOperation.isPresent()){
                    System.out.println(lastOperation.get());
                } else {
                    System.out.println("История пуста!");
                }
                continue;
            } else if(checkCommand(expression, PROGRAM_HELP_COMMAND)) {
                printHelp();
                continue;
            } else if(checkCommand(expression, PROGRAM_CLEAR_HISTORY_COMMAND)) {
                history.clear();
                System.out.println("История очищена успешно!");
                continue;
            }

            String[] elements = expression.split(" ");
            if(elements.length != MAX_ELEMENTS_IN_EXPRESSION) {
                System.out.println(INVALID_FORMAT_MESSAGE);
                continue;
            }
            try {
                double num1 = Double.parseDouble(elements[0]);
                double num2 = Double.parseDouble(elements[2]);
                String operator = elements[1];

                double result = Calculator.calculate(num1, num2, operator);
                history.add(expression + " = " + result);

                System.out.printf("%s = %s%n", expression, result);
            } catch (NumberFormatException error) {
                System.out.println(INVALID_FORMAT_MESSAGE);
            } catch (ArithmeticException | IllegalArgumentException error) {
                System.out.println(error.getMessage());
            }
        }
    }
}