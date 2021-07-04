package com.practise.multithreading;


public class ThreeThreadCommunication implements Runnable {

    private static final Object lock = new Object();
    private static int START_NUM = 1;
    private final int remainder;


    public ThreeThreadCommunication(int remainder) {
        this.remainder = remainder;
    }

    @Override
    public void run() {
        // 1 % 3 == 1, 2 % 3 == 2 , 3 % 3 == 0
        synchronized (lock) {
            while (START_NUM < 100 - 1) {
                while (START_NUM % 3 != remainder) {
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println("Value printed by Thread : " + Thread.currentThread().getName() +
                        " is : " + START_NUM);
                START_NUM++;
                lock.notifyAll();
            }
        }
    }

}
