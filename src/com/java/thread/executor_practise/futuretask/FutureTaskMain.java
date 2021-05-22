package com.java.thread.executor_practise.futuretask;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;

public class FutureTaskMain {
    public static void main(String[] args) throws ExecutionException, InterruptedException {


        Multiplication m1 = new Multiplication(30, 41, 2000);
        Multiplication m2 = new Multiplication(323, 434, 5000);

        FutureTask<Integer> futureTask = new FutureTask<>(m1);
        FutureTask<Integer> futureTask1 = new FutureTask<>(m2);

        ExecutorService executorService = Executors.newFixedThreadPool(2);

        executorService.execute(futureTask1);
        executorService.execute(futureTask);

        if (!futureTask.isDone()) {
            System.out.println("m1 result :" + futureTask.get());
        }

        if (!futureTask1.isDone()) {
            System.out.println("m2 result:" + futureTask1.get());
        }

        executorService.shutdown();

    }
}
