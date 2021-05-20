package com.java.thread.executor_practise;

public class MyRunnable implements Runnable {

    String taskName;

    public MyRunnable(String taskName) {
        this.taskName = taskName;
    }

    @Override
    public void run() {

        System.out.println("Inside Run method of " + this.getClass().getCanonicalName());
        for (int i = 1; i <= 10; i++) {
            System.out.println("Executing " + taskName + " using thread " + Thread.currentThread().getName());
        }
        System.out.println("Completed run method of " + this.getClass().getCanonicalName());
    }

}
