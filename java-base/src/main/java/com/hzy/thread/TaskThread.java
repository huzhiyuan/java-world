package com.hzy.thread;

public class TaskThread implements Runnable{
    private ITask task;

    private long startTime;

    public String getName(){
        return task.getName();
    }
    public TaskThread(ITask task){
        this.task = task;
        //this.startTime=System.currentTimeMillis();
    }

    @Override
    public void run() {
        startTime = System.currentTimeMillis();
        System.out.println(startTime);
        task.run();
    }

    public long getStartTime() {
        return startTime;
    }

    public void setStartTime(long startTime) {
        this.startTime = startTime;
    }

    public ITask getTask() {
        return task;
    }

    public void setTask(ITask task) {
        this.task = task;
    }
}
