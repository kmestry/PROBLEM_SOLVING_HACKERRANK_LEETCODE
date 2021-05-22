package com.java.thread.cyclicbarrier;

public class CyclicBarrierFinishEvent implements Runnable {
    @Override
    public void run() {
        System.out.println("Finish event is triggered now");
        System.out.println("U can update shared variables if any!");
    }
}
