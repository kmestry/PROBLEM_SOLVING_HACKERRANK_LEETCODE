package com.java.thread.printoddeven;

public class PrintSequenceThreeThreads implements Runnable {

    static Object lock = new Object();  // static is imp ..otherwise IllegalMonitorStateException
    int remainder;
    static int number = 1; //IllegalMonitorStateException

    public PrintSequenceThreeThreads(int remainder) {
        this.remainder = remainder;
    }

    @Override
    public void run() {

        while (number < 9) {
            synchronized (lock) {

                while (number % 3 != remainder && number < 9) {
                    try {
                       // System.out.println("==" + Thread.currentThread().getName());
                        lock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println("lock by " + Thread.currentThread().getName() + "==" + number);
                number++;
                lock.notifyAll();

            }
        }
    }
}
