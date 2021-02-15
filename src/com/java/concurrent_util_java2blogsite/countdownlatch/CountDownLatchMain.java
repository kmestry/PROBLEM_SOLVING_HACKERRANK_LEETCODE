package com.java.concurrent_util_java2blogsite.countdownlatch;

import java.util.concurrent.CountDownLatch;

public class CountDownLatchMain {

    public static void main(String[] args) {
        CountDownLatch countDownLatch = new CountDownLatch(3);

        UiInitialization uiInitialization = new UiInitialization(countDownLatch);
        LoggingInitialization loggingInitialization = new LoggingInitialization(countDownLatch);
        DatabaseInitialization databaseInitialization = new DatabaseInitialization(countDownLatch);

        Thread t1 = new Thread(uiInitialization);
        Thread t2 = new Thread(loggingInitialization);
        Thread t3 = new Thread(databaseInitialization);

        t1.start();
        t2.start();
        t3.start();

        try {
            countDownLatch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Main thread resumed after countdown latch reached 0");
    }
}
