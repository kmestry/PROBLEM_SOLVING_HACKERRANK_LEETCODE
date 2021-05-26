package com.java.thread;

public class ThreadTestRunnable {

    public static void main(String[] args) throws InterruptedException {
        ThreadTestRunnable threadTestRunnable = new ThreadTestRunnable();
        ThreadTestRunnable threadTestRunnable1 = new ThreadTestRunnable();

        threadTestRunnable.m1();
        threadTestRunnable1.m1();
    }

    public synchronized void m1() throws InterruptedException {
        System.out.println("In m1 method!!");
        Thread.sleep(5000);
    }
}
