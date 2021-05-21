package com.java.thread.executor_practise.futuretask;

import java.util.concurrent.Callable;

public class Multiplication implements Callable {

    int num1;
    int num2;
    long sleepTime;

    public Multiplication(int num1, int num2, long sleepTime) {
        this.num1 = num1;
        this.num2 = num2;
        this.sleepTime = sleepTime;
    }

    @Override
    public Integer call() throws Exception {
        Thread.sleep(sleepTime);
        return num1 * num2;
    }
}
