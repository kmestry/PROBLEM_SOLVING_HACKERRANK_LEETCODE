package com.java.thread.executor_practise;

import java.util.concurrent.Callable;

public class PowerCalculation implements Callable {

    double number;

    public PowerCalculation(double number) {
        this.number = number;
    }

    @Override
    public Double call() throws Exception {
        System.out.println("Inside call : " + this.getClass().getName());
        System.out.println("Using thread : " + Thread.currentThread().getName());
        Thread.sleep(1000);
        return Math.pow(number, number);
    }
}
