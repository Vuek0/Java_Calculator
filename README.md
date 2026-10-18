# Calculator Project

Консольный калькулятор на Java с историей вычислений

## Возможности

- Базовые операции: +, -, *, /
- Поддержка чисел с плавающей точкой
- История последних 10 вычислений
- Команды: history, last, clear, help, exit
- Архитектура: каждая операция - отдельный класс (паттерн Strategy)

## Технологии

- Java 21
- Maven
- JUnit 5

## Запуск

git clone https://github.com/Vuek0/Java_Calculator.git
cd Java_Calculator
mvn compile
mvn exec:java '-Dexec.mainClass=com.vuek0.Main'

## Тесты

mvn test