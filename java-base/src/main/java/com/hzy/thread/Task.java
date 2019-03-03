package com.hzy.thread;

public class Task implements ITask {

    public String name = "task1";
    @Override
    public void run(){
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("task runing");
    }

    @Override
    public String getName() {
        return name;
    }
}
