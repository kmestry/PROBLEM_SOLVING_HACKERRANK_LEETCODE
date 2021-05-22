package com.java.thread.countdownlatch;

import java.util.concurrent.CountDownLatch;

public class MainClass {

    public static void main(String[] args) throws InterruptedException {
        CountDownLatch countDownLatch = new CountDownLatch(3);

        DatabaseInitializer databaseInitializer = new DatabaseInitializer(countDownLatch);
        LoggingInitializer loggingInitializer = new LoggingInitializer(countDownLatch);
        UiInitializer uiInitializer = new UiInitializer(countDownLatch);

        Thread t1 = new Thread(databaseInitializer);
        Thread t2 = new Thread(loggingInitializer);
        Thread t3 = new Thread(uiInitializer);

        t1.start();
        t2.start();
        t3.start();
        countDownLatch.await();

        System.out.println("Main executed !");
    }
}
