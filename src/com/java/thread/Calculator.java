package com.java.thread;

public class Calculator implements Runnable {

    long sum = 0;

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            sum += i;
        }
        notifyAll();
    }
}
