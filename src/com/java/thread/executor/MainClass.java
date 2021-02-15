package com.java.thread.executor;

import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

public class MainClass {
    public static void main(String[] args) {
        ThreadPoolExecutor service = (ThreadPoolExecutor) Executors.newFixedThreadPool(5);

        for (int i = 0; i < 10; i++) {
            ExecutorFixedThreadPool executorFixedThreadPool = new ExecutorFixedThreadPool("File + " + i);
            service.submit(executorFixedThreadPool);
        }
        System.out.println("=4-3=4-34=-34=34-3=-=========" + Runtime.getRuntime().availableProcessors());
        System.out.println("=4-3=4-34=-34=34-3=-=========" + Runtime.getRuntime().maxMemory());

        service.shutdown();
    }
}
