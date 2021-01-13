package com.java.thread.executor;

public class ExecutorFixedThreadPool implements Runnable {

    String fileName;

    ExecutorFixedThreadPool(String fileName) {
        this.fileName = fileName;
    }

    public String getFileName() {
        return fileName;
    }

    @Override
    public void run() {
        System.out.println("Fetching data from " + fileName + " by " + Thread.currentThread().getName());
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Read file successfully: " + fileName + " by " + Thread.currentThread().getName());
    }
}
