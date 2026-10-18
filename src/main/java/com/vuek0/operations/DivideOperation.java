package com.vuek0.operations;

public class DivideOperation implements Operation {
    private static final String ZERO_DIVIDE_ERROR_MESSAGE = "Ошибка: деление на ноль";

    @Override
    public double execute(double num1, double num2){
        if(num2 == 0){
            throw new ArithmeticException(ZERO_DIVIDE_ERROR_MESSAGE);
        }
        return num1 / num2;
    }
}

