package com.hzy.thread;

public class Main {
    public static void main(String[] args) {
        ITask task = new Task();
        ITask task2 = new Task2();
        TaskManager taskManager = new TaskManager();
        taskManager.execute(task);
        taskManager.execute(task2);
        for (int i = 0; i < 10; i++) {
            System.out.println(i);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
