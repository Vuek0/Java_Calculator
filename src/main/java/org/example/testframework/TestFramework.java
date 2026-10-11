package org.example.testframework;

import java.util.Objects;
import java.util.function.Supplier;

public class TestFramework {
    private static String red(String str){
        return "\u001B[31m" + str + "\u001B[0m";
    }

    private static String green(String str){
        return "\u001B[32m" + str + "\u001B[0m";
    }

    public static <T> void doTest(Supplier<T> method, T expectedResult) {
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
}
