package com.java.thread.executor;

import java.util.concurrent.Callable;

public class MultiplyingTask implements Callable {

    int num1;
    int num2;
    int sleepTime;

    public MultiplyingTask(int num1, int num2, int sleepTime) {
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
