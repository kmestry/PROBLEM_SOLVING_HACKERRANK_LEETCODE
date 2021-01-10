package com.java.thread.join;

public class MyRunnable implements Runnable {

    @Override
    public void run() {
        System.out.println("Thread.currentThread().getName() =starting " + Thread.currentThread().getName());
        try {
            Thread.sleep(10000);
            System.out.println("Thread.currentThread().getName() = ended " + Thread.currentThread().getName());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}

