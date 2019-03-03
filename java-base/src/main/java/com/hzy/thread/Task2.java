package com.hzy.thread;

public class Task2 implements ITask{
    public String name = "task2";
    public void run(){
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("task2 runing");
    }

    @Override
    public String getName() {
        return name;
    }
}
