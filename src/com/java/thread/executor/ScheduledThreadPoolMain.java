package com.java.thread.executor;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

public class ScheduledThreadPoolMain {

    public static void main(String[] args) {
        ScheduledExecutorService executorService = Executors.newScheduledThreadPool(3);

        for (int i = 1; i <= 10; i++) {
            ExecutorFixedThreadPool runnableTask = new ExecutorFixedThreadPool("File " + i);

            ScheduledFuture future = executorService.schedule(runnableTask, 10, TimeUnit.SECONDS);
         /*   try {
                System.out.println("status===="+future.get());
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }*/
        }

        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        executorService.shutdown();
    }
}
