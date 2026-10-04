import java.util.Scanner;
import java.util.function.Supplier;
import java.util.Objects;
class Main {

    private static String red(String str){
        return "\u001B[31m" + str + "\u001B[0m";
    }

    private static String green(String str){
        return "\u001B[32m" + str + "\u001B[0m";
    }

    private static <T> void doTest(Supplier<T> method, T expectedResult) {
        try {
            T result = method.get();

            if(Objects.equals(result, expectedResult)){
                System.out.printf(green("Тест пройден успешно!%n" +
                                "Ожидаемый результат: %s | Полученный результат: %s%n"),
                        expectedResult, result);
            } else {
                System.out.printf(red("Тест не пройден.%n" +
                                "Ожидаемый результат: %s | Полученный результат: %s%n"),
                        expectedResult, result);
            }
        } catch (Exception error) {
            System.out.printf(red("При воспроизведении теста произошла ошибка!%n%s%n"),
                    error);
        }

    }

    private static void tests() {
        System.out.println("--- Тесты ---");
        doTest(() -> calculate(5, 3, "+"), 8);
        doTest(() -> calculate(5, 2, "/"), 2);
        doTest(() -> calculate(10, 3, "-"), 7);
        doTest(() -> calculate(4, 6, "*"), 24);
        System.out.println("--- Конец тестов ---\n");
    }

    private static int calculate(int num1, int num2, String operator){
        return switch(operator){
            case "+" -> num1 + num2;
            case "-" -> num1 - num2;
            case "*" -> num1 * num2;
            case "/" -> {
                if(num2 == 0) throw new IllegalArgumentException("Ошибка: деление на ноль");
                yield num1 / num2;
            }
            default -> throw new NumberFormatException();
        };
    }

    public static void main(String[] args) {
        tests();

        Scanner scanner = new Scanner(System.in);
        System.out.println("Это калькулятор! Вводить выражения в виде: число оператор число\n" +
                "Для того чтобы выйти из программы напишите 'exit'");
        while(true) {
            System.out.print("Введите выражение: ");
            String expression = scanner.nextLine();
            if(expression.trim().equals("exit")) break;

            String[] elements = expression.split(" ");
            if(elements.length != 3) {
                System.out.println("Ошибка: неверный формат. Используйте: число оператор число");
                continue;
            }
            try {
                int num1 = Integer.parseInt(elements[0]);
                int num2 = Integer.parseInt(elements[2]);
                String operator = elements[1];

                int result = calculate(num1, num2, operator);
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