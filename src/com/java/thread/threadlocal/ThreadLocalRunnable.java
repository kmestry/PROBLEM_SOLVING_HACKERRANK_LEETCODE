package com.java.thread.threadlocal;

public class ThreadLocalRunnable implements Runnable {

    public static void main(String[] args) {
        ThreadLocalRunnable threadLocalRunnable = new ThreadLocalRunnable();

        Thread t1 = new Thread(threadLocalRunnable);
        Thread t2 = new Thread(threadLocalRunnable);

        t1.start();
        t2.start();
    }

    @Override
    public void run() {
        ThreadLocal<Integer> threadLocal = new ThreadLocal<>();

        threadLocal.set((int) (32 * Math.random()));

        System.out.println("Thread local value is " + threadLocal.get());
    }
}