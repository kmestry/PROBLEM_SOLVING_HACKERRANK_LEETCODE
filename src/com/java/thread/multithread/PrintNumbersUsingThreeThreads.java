package com.java.thread.multithread;

public class PrintNumbersUsingThreeThreads implements Runnable {

    private static final int END_VALUE = 10;
    private static final Object object = new Object();
    static int START_VALUE = 1;
    //
    int remainder;

    public PrintNumbersUsingThreeThreads(int threadNum) {
        this.remainder = threadNum;
    }

    // 1 % 0 = 1
    // 1 % 1 = 0
    // 1 % 2 = 1


    @Override
    public void run() {
        while (START_VALUE < END_VALUE - 1) {
            synchronized (object) {
                //1 % 3 == 1..
                // 1 % 3
                while (START_VALUE % 3 != remainder) {
                    try {
                        object.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }


                System.out.println("Printing value : " + START_VALUE + " Thread used : " + Thread.currentThread().getName());
                START_VALUE++;
                object.notifyAll();

            }
        }

    }
}
