package com.java.thread.executor_practise;

import java.util.concurrent.*;

public class MyRunnableMain {

    public static void main(String[] args) throws ExecutionException, InterruptedException {


        ExecutorService threadPoolExecutor = Executors.newFixedThreadPool(3);

        ScheduledExecutorService executorService = Executors.newScheduledThreadPool(3);

        for (int i = 1; i < 6; i++) {
            MyRunnable myRunnable = new MyRunnable("file trimming!" + i);
            Future<?> t = threadPoolExecutor.submit(myRunnable);
            System.out.println("Future result " + t.get());

            // threadPoolExecutor.execute(myRunnable);

        }

        threadPoolExecutor.shutdown();

    }
}
