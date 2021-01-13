package com.java.thread.executor;

import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadPoolExecutor;

public class RejectionHandler implements RejectedExecutionHandler {
    @Override
    public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {
        ExecutorFixedThreadPool executorFixedThreadPool = (ExecutorFixedThreadPool) r;
        System.out.println("Sorry!! We won't be able to read :" + executorFixedThreadPool.getFileName());
    }
}
