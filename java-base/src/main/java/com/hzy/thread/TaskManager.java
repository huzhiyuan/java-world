package com.hzy.thread;

import com.google.common.util.concurrent.ThreadFactoryBuilder;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.*;

public class TaskManager {
    private static ScheduledExecutorService timer;
    private static Runnable monitor;

    private static Map<String, Future> tasks = new HashMap<>();
    private static List<TaskThread> taskThreads = new ArrayList<>();
    static{
        timer = new ScheduledThreadPoolExecutor(3,
                new ThreadFactory() {
                    @Override
                    public Thread newThread(Runnable r) {
                        Thread thread = new Thread(r);
                        //设置为守护线程
                        thread.setDaemon(true);
                        thread.setName("Thread--001");
                        return thread;
                    }
                },
                new ThreadPoolExecutor.AbortPolicy());
        monitor = new Runnable() {
            @Override
            public void run() {
                while(true){
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(TaskManager.getTasks().size());
                    for(TaskThread taskThread:TaskManager.getTaskThreads()){
                        if(System.currentTimeMillis()-taskThread.getStartTime()>3000){
                            TaskManager.cancel(taskThread.getTask());
                        }
                    }
                }
            }
        };
        Thread s = new Thread(monitor);
        s.setDaemon(true);
        s.start();
    }

    public void execute(ITask task){
        TaskThread taskThread = new TaskThread(task);
        taskThreads.add(taskThread);
        Future f =timer.scheduleAtFixedRate(taskThread,0,1000, TimeUnit.MILLISECONDS);
        tasks.put(task.toString(),f);
    }

    public static void cancel(ITask task){
        tasks.get(task.getName()).cancel(true);
    }

    public static ScheduledExecutorService getTimer() {
        return timer;
    }

    public static void setTimer(ScheduledExecutorService timer) {
        TaskManager.timer = timer;
    }

    public static Map<String, Future> getTasks() {
        return tasks;
    }

    public static void setTasks(Map<String, Future> tasks) {
        TaskManager.tasks = tasks;
    }

    public static List<TaskThread> getTaskThreads() {
        return taskThreads;
    }

    public static void setTaskThreads(List<TaskThread> taskThreads) {
        TaskManager.taskThreads = taskThreads;
    }
}
