package com.practise;

public class TenThreads implements Runnable {

    private static final Object objLock = new Object();
    static int counter = 0;
    int threadNum;

    TenThreads(int threadNum) {
        this.threadNum = threadNum;
    }

    @Override
    public void run() {

        synchronized (objLock) {
            while (counter <= 100 - 10) {
                while (counter % 10 != threadNum) {
                    try {
                        objLock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                }
                System.out.println("Thread name :" + Thread.currentThread().getName() + " value is " + counter);
                counter++;

                /*try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }*/
                objLock.notifyAll();
            }
        }
    }

}

