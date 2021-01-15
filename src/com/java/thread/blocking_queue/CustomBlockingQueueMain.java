package com.java.thread.blocking_queue;

public class CustomBlockingQueueMain {

    public static void main(String[] args) {
        CustomBlockingQueue customBlockingQueue = new CustomBlockingQueue(5);

        Thread thread1 = new Thread(new Producer(customBlockingQueue));
        Thread thread2 = new Thread(new Consumer(customBlockingQueue));

        thread1.start();
        thread2.start();
    }


}

class Producer implements Runnable {

    CustomBlockingQueue customBlockingQueue;

    public Producer(CustomBlockingQueue customBlockingQueue) {
        this.customBlockingQueue = customBlockingQueue;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            customBlockingQueue.put(i);
        }
    }
}

class Consumer implements Runnable {

    CustomBlockingQueue customBlockingQueue;

    public Consumer(CustomBlockingQueue customBlockingQueue) {
        this.customBlockingQueue = customBlockingQueue;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            customBlockingQueue.take();
        }
    }
}
