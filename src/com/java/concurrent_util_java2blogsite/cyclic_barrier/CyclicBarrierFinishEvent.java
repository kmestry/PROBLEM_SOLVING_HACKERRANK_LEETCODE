package com.java.concurrent_util_java2blogsite.cyclic_barrier;

public class CyclicBarrierFinishEvent implements Runnable {
    @Override
    public void run() {
        System.out.println("As 3 threads have reached common barrier point "
                + ", CyclicBarrierFinishEvent has been triggered");
        System.out.println("You can update shared variables if any");
    }
}
