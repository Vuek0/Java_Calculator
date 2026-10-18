package com.vuek0.tests;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import com.vuek0.operations.Operation;
import com.vuek0.operations.AddOperation;
import com.vuek0.operations.SubtractOperation;
import com.vuek0.operations.MultiplyOperation;
import com.vuek0.operations.DivideOperation;
import com.vuek0.operations.ModuloOperation;


public class OperationsTest {
    @Test
    void addOperationWorks(){
        Operation op = new AddOperation();
        assertEquals(8.0, op.execute(5.0, 3.0));
    }

    @Test
    void subtractOperationWorks(){
        Operation op = new SubtractOperation();
        assertEquals(10.0, op.execute(20.0, 10.0));
    }

    @Test
    void multiplyOperationWorks(){
        Operation op = new MultiplyOperation();
        assertEquals(15.0, op.execute(5.0, 3.0));
    }

    @Test
    void divideOperationWorks(){
        Operation op = new DivideOperation();
        assertEquals(9.0, op.execute(27.0, 3.0));
    }

    @Test
    void modulusOperationWorks(){
        Operation op = new ModuloOperation();
        assertEquals(1.0, op.execute(21.0, 2.0));
    }

    // Exceptions below

    @Test
    void zeroDivisionThrowsException(){
        Operation op = new DivideOperation();
        assertThrows(ArithmeticException.class,
                () -> op.execute(10.0, 0.0));
    }
}
