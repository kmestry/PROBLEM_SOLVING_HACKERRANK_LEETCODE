package com.java.concurrent_util_java2blogsite.blocking_queue;

import java.util.concurrent.BlockingQueue;

public class Producer implements Runnable {

    private final BlockingQueue blockingQueue;

    public Producer(BlockingQueue blockingQueue) {
        this.blockingQueue = blockingQueue;
    }


    @Override
    public void run() {

        for (int i = 0; i < 50; i++) {
            try {
                System.out.println("Putting item : " + i);
                blockingQueue.put(i);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
