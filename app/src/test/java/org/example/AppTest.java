package org.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class AppTest {
    @Test
    public void testAddAndComplete() {
        TodoList list = new TodoList();
        list.add("Task1");
        list.add("Task2");
        assertEquals(2, list.countAll());

        list.complete("Task2");
        assertEquals(1, list.countComplete());
        assertEquals(1, list.countIncomplete());
    }

    @Test
    public void testClear() {
        TodoList list = new TodoList();
        list.add("Alpha");
        list.add("Beta");
        list.clear();
        assertEquals(0, list.countAll());
    }

    @Test
    public void testEmptyTask() {
        TodoList list = new TodoList();
        list.add("");
        list.add("   ");
        list.add(null);
        assertEquals(0, list.countAll());
    }
}
