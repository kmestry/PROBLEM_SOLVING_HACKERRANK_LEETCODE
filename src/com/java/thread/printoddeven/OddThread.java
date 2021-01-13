package com.java.thread.printoddeven;

public class OddThread extends ParentThread implements Runnable {


    private final ParentThread p;

    public OddThread(ParentThread p) {
        this.p = p;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e1) {
            e1.printStackTrace();
        }
        synchronized (this) {
            // Print number till the N
            while (p.startingNum < p.max) {

                while (p.isOdd) {
                    try {
                        wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

                System.out.println(".s = " + p.startingNum);
                p.startingNum++;
                p.isOdd = true;
                notify();

            }
        }


    }
}
