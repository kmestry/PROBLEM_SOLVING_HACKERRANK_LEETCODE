package com.java.thread.executor_practise;

import java.util.concurrent.Callable;

public class FactorialCalculation implements Callable {

    double number;

    public FactorialCalculation(double number) {
        this.number = number;
    }

    @Override
    public Object call() throws Exception {
        System.out.println("Inside call: " + this.getClass().getName());
        System.out.println("Using thread :" + Thread.currentThread().getName());
        Thread.sleep(4000);
        double factorial = 1;
        for (int i = 2; i <= number; i++) {
            factorial *= i;
        }
        return factorial;
    }
}
