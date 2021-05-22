package com.java.thread.countdownlatch;

import java.util.concurrent.CountDownLatch;

public class DatabaseInitializer implements Runnable {
    CountDownLatch countDownLatch;

    public DatabaseInitializer(CountDownLatch countDownLatch) {
        this.countDownLatch = countDownLatch;
    }

    @Override
    public void run() {

        System.out.println("Inside run. : " + this.getClass().getName());
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Completed countdown in : " + this.getClass().getName());

        countDownLatch.countDown();
    }
}
