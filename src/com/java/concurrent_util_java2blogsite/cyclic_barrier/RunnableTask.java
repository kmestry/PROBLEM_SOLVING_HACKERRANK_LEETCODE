package com.java.concurrent_util_java2blogsite.cyclic_barrier;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class RunnableTask implements Runnable {

    CyclicBarrier cyclicBarrier;
    long sleepTime;

    public RunnableTask(CyclicBarrier cyclicBarrier, long sleepTime) {
        this.cyclicBarrier = cyclicBarrier;
        this.sleepTime = sleepTime;
    }

    @Override
    public void run() {

        try {
            Thread.sleep(sleepTime);
            System.out.println(Thread.currentThread().getName() +
                    " is waiting for " + (cyclicBarrier.getParties() - cyclicBarrier.getNumberWaiting() - 1) +
                    " other threads to reach common barrier point");
            cyclicBarrier.await();
        } catch (InterruptedException | BrokenBarrierException e) {
            e.printStackTrace();
        }
        System.out.println("As " + cyclicBarrier.getParties() + " threads have reached common barrier point "
                + Thread.currentThread().getName() +
                " has been released");
    }
}
