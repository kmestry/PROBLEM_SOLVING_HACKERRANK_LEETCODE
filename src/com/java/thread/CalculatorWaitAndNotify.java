package com.java.thread;

public class CalculatorWaitAndNotify {

    public static void main(String[] args) throws InterruptedException {

        Calculator calculator = new Calculator();
        Thread t = new Thread(calculator);

        t.start();

        synchronized (t) {
            t.wait();
        }

        System.out.println(calculator.sum);

        t.notifyAll();

    }
}
