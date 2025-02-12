package org.example;

import java.util.ArrayList;
import java.util.List;

class TodoList {
    private static class Task {
        String description;
        boolean completed;
        Task(String d) {
            description = d;
            completed = false;
        }
    }

    private List<Task> tasks;

    public TodoList() {
        tasks = new ArrayList<>();
    }

    public void add(String desc) {
        if (desc == null || desc.trim().isEmpty()) {
            System.out.println("Cannot add an empty task.");
            return;
        }
        tasks.add(new Task(desc));
    }

    public void complete(String desc) {
        for (Task t : tasks) {
            if (t.description.equals(desc)) {
                t.completed = true;
                break;
            }
        }
    }

    public void all() {
        if (tasks.isEmpty()) {
            System.out.println("No tasks in the list.");
            return;
        }
        for (Task t : tasks) {
            System.out.println(t.description + (t.completed ? " [Done]" : " [Not Done]"));
        }
    }

    public void complete() {
        boolean found = false;
        for (Task t : tasks) {
            if (t.completed) {
                System.out.println(t.description + " [Done]");
                found = true;
            }
        }
        if (!found) {
            System.out.println("No completed tasks.");
        }
    }

    public void incomplete() {
        boolean found = false;
        for (Task t : tasks) {
            if (!t.completed) {
                System.out.println(t.description + " [Not Done]");
                found = true;
            }
        }
        if (!found) {
            System.out.println("No incomplete tasks.");
        }
    }

    public void clear() {
        tasks.clear();
    }

    public int countAll() {
        return tasks.size();
    }

    public int countComplete() {
        int count = 0;
        for (Task t : tasks) {
            if (t.completed) count++;
        }
        return count;
    }

    public int countIncomplete() {
        int count = 0;
        for (Task t : tasks) {
            if (!t.completed) count++;
        }
        return count;
    }
}

public class App {
    public static void main(String[] args) {
        TodoList list = new TodoList();

        list.add("Buy milk");
        list.add("Buy eggs");
        list.add("Prepare a lesson for CSC 122");
        list.add("Sow beet seeds");

        list.complete("Buy eggs");

        System.out.println("All tasks:");
        list.all();

        System.out.println("\nCompleted tasks:");
        list.complete();

        System.out.println("\nIncomplete tasks:");
        list.incomplete();

        list.clear();

        System.out.println("\nAfter clearing:");
        list.all();
    }
}
