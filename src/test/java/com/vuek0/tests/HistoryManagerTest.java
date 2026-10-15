package com.vuek0.tests;

import com.vuek0.calculator.HistoryManager;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertAll;

public class HistoryManagerTest {
    @Test
    void historyStoresOperations() {
        HistoryManager history = new HistoryManager();
        history.add("5.0 + 3.0 = 8.0");
        assertEquals(1, history.getSize());
    }

    @Test
    void historyCleared() {
        HistoryManager history = new HistoryManager();
        history.add("5.0 + 3.0 = 8.0");
        history.clear();
        assertEquals(0, history.getSize());
    }

    @Test
    void historyReturnsLastOperation() {
        HistoryManager history = new HistoryManager();
        history.add("5.0 + 3.0 = 8.0");
        history.add("10.0 - 4.0 = 6.0");
        history.add("20.0 / 5.0 = 4.0");

        assertEquals("20.0 / 5.0 = 4.0", history.getLastOperation().get());
    }

    @Test
    void historyReturnsEmptyOptional() {
        HistoryManager history = new HistoryManager();
        assertEquals(Optional.empty(), history.getLastOperation());
    }

    @Test
    void historyStoresOnly10Operations() {
        HistoryManager history = new HistoryManager();

        history.add("5.0 + 3.0 = 8.0");
        history.add("10.0 - 4.0 = 6.0");
        history.add("20.0 / 5.0 = 4.0");
        history.add("7.0 * 6.0 = 42.0");
        history.add("15.0 + 25.0 = 40.0");
        history.add("100.0 - 37.0 = 63.0");
        history.add("9.0 / 2.0 = 4.5");
        history.add("8.0 * 8.0 = 64.0");
        history.add("12.0 + 18.0 = 30.0");
        history.add("50.0 / 4.0 = 12.5");
        history.add("99.0 - 9.0 = 90.0");

        assertAll(
            () -> assertEquals(10, history.getSize()),
            () -> assertEquals("99.0 - 9.0 = 90.0",
                history.getLastOperation().get())
        );
        ;

    }
}
