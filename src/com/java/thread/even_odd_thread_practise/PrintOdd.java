package com.java.thread.even_odd_thread_practise;

public class PrintOdd implements Runnable {
    final Number number;

    public PrintOdd(Number number) {
        this.number = number;
    }

    @Override
    public void run() {

        synchronized (number) {
            while (number.start < number.end) {
                while (number.start % 2 == 0) {
                    try {
                        System.out.println("waiting in PrintOdd");
                        number.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

                System.out.println("Thread is : " + Thread.currentThread().getName()
                        + " value is :" + number.getStart());
                number.start++;
                System.out.println("Notifying Even..");
                number.notify();
            }
        }
    }
}
