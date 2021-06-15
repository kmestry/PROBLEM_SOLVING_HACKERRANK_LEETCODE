package com.java.thread.baeldung;

import java.util.LinkedList;
import java.util.List;

public class BlockingQueueTest<T> {

    private final int queueLimit = 10;
    List<T> queue = new LinkedList<>();

    private synchronized void put(T item) throws InterruptedException {
        while (queue.size() == queueLimit) {
            wait();
        }
        if (queue.isEmpty()) {
            notifyAll();
        }
        queue.add(item);
    }

    private synchronized T take() throws InterruptedException {
        while (queue.isEmpty()) {
            wait();
        }
        if (queue.size() == queueLimit) {
            notifyAll();
        }
        return queue.remove(0);
    }
}
