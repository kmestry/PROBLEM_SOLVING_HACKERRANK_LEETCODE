package com.java.thread.blocking_queue;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class CustomBlockingQueue {

    int size;
    Object[] array;
    Lock lock = new ReentrantLock();
    final Condition producerCondition = lock.newCondition();
    final Condition consumerCondition = lock.newCondition();
    int putIndex;
    int takeIndex;
    int count;

    public CustomBlockingQueue(int size) {
        this.size = size;
        this.array = new Object[size];
    }


    public void put(Object obj) {
        lock.lock();
        try {
            while (count > array.length - 1) {
                producerCondition.await();
            }
            array[putIndex] = obj;
            System.out.println("put value :" + obj);
            putIndex++;
            count++;
            if (putIndex > array.length - 1) {
                putIndex = 0;
            }
            consumerCondition.signal();

        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public Object take() {
        lock.lock();

        try {
            while (count == 0) {
                consumerCondition.await();
            }
            Object returnVal = array[takeIndex];
            takeIndex++;
            count--;
            if (takeIndex > array.length - 1) {
                takeIndex = 0;
            }
            producerCondition.signal();
            System.out.println("take value" + returnVal);
            return returnVal;
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
        return null;
    }


}
