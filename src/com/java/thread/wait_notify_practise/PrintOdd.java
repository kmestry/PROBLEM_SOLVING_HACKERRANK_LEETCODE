package com.java.thread.wait_notify_practise;

public class PrintOdd implements Runnable {

    final NumberI numberI;


    public PrintOdd(NumberI numberI) {
        this.numberI = numberI;
    }

    @Override
    public void run() {
        synchronized (numberI) {

            while (numberI.startVal <= numberI.endVal) {
                try {
                    System.out.println("Waiting odd");
                    numberI.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                if (!numberI.isEven) {
                    System.out.println("value printed by thread  : " + Thread.currentThread().getName() + " : " + numberI.startVal);
                    numberI.startVal++;
                    numberI.isEven = true;
                    System.out.println("notify even!");
                    numberI.notify();
                }
            }
        }

    }
}
