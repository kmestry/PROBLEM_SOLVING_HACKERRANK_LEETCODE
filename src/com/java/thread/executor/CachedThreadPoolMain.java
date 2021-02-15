package com.java.thread.executor;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CachedThreadPoolMain {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newCachedThreadPool();

        for (int i = 1; i <= 10; i++) {
            ExecutorFixedThreadPool executorFixedThreadPool = new ExecutorFixedThreadPool("File " + i);
            executorService.submit(executorFixedThreadPool);
        }
    }
}
