package com.java.thread.join;

public class MyRunnableMain {
    public static void main(String[] args) {

        MyRunnable myRunnable = new MyRunnable();
        Thread t1 = new Thread(myRunnable, "thread 1");
        Thread t2 = new Thread(myRunnable, "thread 2");
        Thread t3 = new Thread(myRunnable, "thread 3");

        t3.setDaemon(true);
        t1.start();
        // lets waits for t1 to die
        try {
            t1.join();
        } catch (InterruptedException e) {

            e.printStackTrace();
        }

        t2.start();
        try {
            // lets waits for 1 sec or t2 to die which ever occurs first
            t2.join(6000);

        } catch (InterruptedException e1) {

            e1.printStackTrace();
        }
        t3.start();

        // complete all threads before completing main thread
        try {
            t2.join();
            t3.join();

        } catch (InterruptedException e1) {

            e1.printStackTrace();
        }
        System.out.println("Main thread execution ends");
    }
}