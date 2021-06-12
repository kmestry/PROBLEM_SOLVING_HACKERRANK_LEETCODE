package com.hackerrank.morgan_coding;

import java.util.concurrent.CyclicBarrier;

public class CyclicBarrieTest {
    public static void main(String[] args) {
        final CyclicBarrier barrier = new CyclicBarrier(3, () -> System.out.println("Lets Play"));
        Runnable r = () -> {
            System.out.println("Awaiting");
            try {
                barrier.await();
            } catch (Exception e) {

            }

        };

        Thread t1 = new Thread(r);
        Thread t2 = new Thread(r);
        Thread t3 = new Thread(r);
        t1.start();
        t2.start();
        t3.start();
    }
}
