package com.vuek0.calculator;

import java.util.HashMap;
import java.util.Map;

import com.vuek0.operations.Operation;
import com.vuek0.operations.AddOperation;
import com.vuek0.operations.SubtractOperation;
import com.vuek0.operations.MultiplyOperation;
import com.vuek0.operations.DivideOperation;
import com.vuek0.operations.ModuloOperation;

public class Calculator {
    private static final Map<String, Operation> OPERATIONS = new HashMap<>(Map.ofEntries(
        Map.entry("+", new AddOperation()),
        Map.entry("-", new SubtractOperation()),
        Map.entry("*", new MultiplyOperation()),
        Map.entry("/", new DivideOperation()),
        Map.entry("%", new ModuloOperation())
    ));

    public static double calculate(double num1, double num2, String operator){

        Operation op = OPERATIONS.get(operator);
        if (op == null){
            throw new IllegalArgumentException("Неизвестный оператор: " + operator);
        }
        return op.execute(num1, num2);
    }
}
