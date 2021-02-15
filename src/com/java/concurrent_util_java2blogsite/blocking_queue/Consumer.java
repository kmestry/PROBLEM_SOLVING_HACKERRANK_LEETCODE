package com.java.concurrent_util_java2blogsite.blocking_queue;

import java.util.concurrent.BlockingQueue;

public class Consumer implements Runnable {

    private final BlockingQueue blockingQueue;

    public Consumer(BlockingQueue blockingQueue) {
        this.blockingQueue = blockingQueue;
    }

    @Override
    public void run() {

        while (true) {
            try {
                int val = (int) blockingQueue.take();
                System.out.println("Consumed item : " + val);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
}
