package com.java.thread.cyclicbarrier;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class RunnableTask implements Runnable {

    private final CyclicBarrier cyclicBarrier;
    long sleepTime;

    public RunnableTask(CyclicBarrier cyclicBarrier, long sleepTime) {
        this.cyclicBarrier = cyclicBarrier;
        this.sleepTime = sleepTime;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(sleepTime);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(Thread.currentThread().getName() + " is waiting for " + (cyclicBarrier.getParties()
                - cyclicBarrier.getNumberWaiting() - 1) + " threads to reach barrier point");

        try {
            cyclicBarrier.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (BrokenBarrierException e) {
            e.printStackTrace();
        }

        System.out.println("As " + cyclicBarrier.getParties() + " have reached barrier point, " +
                Thread.currentThread().getName() + " is Released !");


    }
}
