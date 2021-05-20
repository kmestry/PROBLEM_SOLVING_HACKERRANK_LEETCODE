package com.java.thread.executor;

import java.util.concurrent.*;

public class MainClassCustomThreadPool {

    public static void main(String[] args) {

        BlockingQueue<Runnable> blockingQueue = new LinkedBlockingQueue<>(4);
        ThreadFactory threadFactory = Executors.defaultThreadFactory();

        RejectionHandler rejectionHandler = new RejectionHandler();
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(1, 2,
                10L, TimeUnit.MILLISECONDS,
                blockingQueue, threadFactory, rejectionHandler);
        for (int i = 1; i <= 10; i++) {
            ExecutorFixedThreadPool executorFixedThreadPool = new ExecutorFixedThreadPool("File " + i);
            threadPoolExecutor.execute(executorFixedThreadPool);
        }
        threadPoolExecutor.shutdown();
    }
}
