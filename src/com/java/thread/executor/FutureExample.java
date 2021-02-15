package com.java.thread.executor;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;

public class FutureExample {

    public static void main(String[] args) {
        MultiplyingTask multiplyingTask1 = new MultiplyingTask(10, 20, 2000);
        MultiplyingTask multiplyingTask2 = new MultiplyingTask(20, 30, 5000);

        FutureTask<Integer> futureTask1 = new FutureTask<>(multiplyingTask1);
        FutureTask<Integer> futureTask2 = new FutureTask<>(multiplyingTask2);

        ExecutorService executorService = Executors.newFixedThreadPool(2);
        executorService.submit(futureTask1);
        executorService.submit(futureTask2);

        while (true) {
            try {
                if (!futureTask1.isDone()) {
                    System.out.println("FutureTask1 output=" + futureTask1.get());
                }
                if (!futureTask2.isDone()) {
                    System.out.println("Waiting for futureTask2 for completion");
                    System.out.println("FutureTask2 output=" + futureTask2.get());
                }
                if (futureTask1.isDone() && futureTask2.isDone()) {
                    System.out.println("FutureTask2 output=" + futureTask2.get());
                    System.out.println("FutureTask1 output=isDone" + futureTask1.get());
                    System.out.println("Completed both the FutureTasks, shutting down the executors");
                    executorService.shutdown();
                    return;
                }

            } catch (InterruptedException | ExecutionException e) {
                e.printStackTrace();
            }
        }


    }
}
