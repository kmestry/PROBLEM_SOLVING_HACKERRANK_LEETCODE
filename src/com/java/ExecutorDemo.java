package com.java;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ExecutorDemo {

    public static void main(String[] args) throws ExecutionException, InterruptedException {

        ExecutorService service = Executors.newSingleThreadExecutor();
        service.submit(() -> System.out.println("inside run method"));
        System.out.println("end of main thread!");

        service.shutdown();

        ExecutorService service1 = Executors.newFixedThreadPool(5);


        ExecutorService service2 = Executors.newScheduledThreadPool(19);

        Future future = service2.submit(() -> System.out.println("using scheduled thread pool!"));

        System.out.println("----" + future.get()); //returns null if task has completed


        Future future1 = service2.submit(() -> "Hi inside callable!");
        System.out.println("====" + future1.get());

        Thread t = new Thread(() -> {
            for (int i = 0; i < 100; i++) {
                System.out.println("i === t == " + i);
            }
        });

        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 100; i++) {
                System.out.println("i ==== t1 == " + i);
            }
        });

        t.start();
        t.join(1000); // main method will wait until thread t completes its operation

        System.out.println("thread t completed!");
        t1.start();
        System.out.println("Thread t1 started");

//        t.wait();
//        t.notify();
        Thread.yield();

        ExecutorDemo executorDemo = new ExecutorDemo();
        executorDemo.wait();
    }

}
