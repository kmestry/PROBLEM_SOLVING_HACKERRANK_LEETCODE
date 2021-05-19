package com.java.thread.even_odd_thread_practise;

public class PrintEven implements Runnable {

    final Number number;

    public PrintEven(Number number) {
        this.number = number;
    }


    @Override
    public void run() {

        synchronized (number) {
            while (number.start < number.end) {
                while (number.start % 2 != 0) {
                    try {
                        System.out.println("waiting in printEven");
                        number.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

                System.out.println("Thread is : " + Thread.currentThread().getName()
                        + " value is :" + number.getStart());
                number.start++;
                System.out.println("Notifying odd..");
                number.notify();
            }
        }
    }
}
