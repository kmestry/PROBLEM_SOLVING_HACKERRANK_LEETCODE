package com.java.concurrent_util_java2blogsite.blocking_queue;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class BlockingQueueMain {
    public static void main(String[] args) {
        BlockingQueue<Runnable> blockingQueue = new ArrayBlockingQueue(10);
        Thread t1 = new Thread(new Producer(blockingQueue));
        Thread t2 = new Thread(new Consumer(blockingQueue));

        t1.start();
        t2.start();
    }
}
