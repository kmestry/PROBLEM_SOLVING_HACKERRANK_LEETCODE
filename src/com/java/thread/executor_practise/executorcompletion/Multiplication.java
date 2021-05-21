package com.java.thread.executor_practise.executorcompletion;

import java.util.concurrent.Callable;

public class Multiplication implements Callable {
    int num1;
    int num2;
    int sleepTime;
    String taskName;

    public Multiplication(int num1, int num2, int sleepTime, String taskName) {
        this.num1 = num1;
        this.num2 = num2;
        this.sleepTime = sleepTime;
        this.taskName = taskName;
    }


    @Override
    public Object call() throws Exception {
        System.out.println("starting  task :" + taskName);
        int result = num1 * num2;
        Thread.sleep(sleepTime);
        System.out.println("Completed task :" + taskName);
        return result;
    }
}
