package com.java.thread.executor_practise;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class MainThreadCallable {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService executorService = Executors.newCachedThreadPool();

        FactorialCalculation factorialCalculation = new FactorialCalculation(20);
        PowerCalculation squareCalculation = new PowerCalculation(20);

        FactorialCalculation factorialCalculation1 = new FactorialCalculation(25);
        PowerCalculation squareCalculation1 = new PowerCalculation(25);

        Future factorialFuture = executorService.submit(factorialCalculation);
        Future squareFuture = executorService.submit(squareCalculation);

        Future factorialFuture1 = executorService.submit(factorialCalculation1);
        Future squareFuture1 = executorService.submit(squareCalculation1);

        System.out.println("factorial of 20 is :" + factorialFuture.get());
        System.out.println("square of 20 is :" + squareFuture.get());
        System.out.println("factorial of 25  is :" + factorialFuture1.get());
        System.out.println("square of 25 is :" + squareFuture1.get());

        executorService.shutdown();
    }
}
