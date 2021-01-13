package com.java.thread.printoddeven;

public class EvenThread implements Runnable {

    private final ParentThread p;

    public EvenThread(ParentThread p) {
        this.p = p;
    }

    @Override
    public void run() {

        synchronized (this) {
            // Print number till the N
            while (p.startingNum < p.max) {

                // If count is odd then print
                while (!p.isOdd) {
                    try {
                        wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println("p.startingNum = " + p.startingNum);
                p.startingNum++;
                p.isOdd = true;
                notify();
            }
        }

    }
}


