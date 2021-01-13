package com.java.concurrent_util_java2blogsite.countdownlatch;

import java.util.concurrent.CountDownLatch;

public class LoggingInitialization implements Runnable {

    private final CountDownLatch countDownLatch;

    public LoggingInitialization(CountDownLatch countDownLatch) {
        this.countDownLatch = countDownLatch;
    }

    @Override
    public void run() {

        System.out.println("Initialization of logging!");
        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Done with initialization of logging!");
        countDownLatch.countDown();

    }
}
