package com.java.thread.wait_notify_practise;

public class PrintEven implements Runnable {

    final NumberI numberI;

    public PrintEven(NumberI numberI) {
        this.numberI = numberI;
    }


    @Override
    public void run() {
        synchronized (numberI) {

            while (numberI.startVal <= numberI.endVal) {
                //  System.out.println("Thread name :" + Thread.currentThread().getName());

                if (numberI.isEven) {
                    System.out.println("value printed by thread  : " + Thread.currentThread().getName() + " : " + numberI.startVal);
                    numberI.startVal++;
                    numberI.isEven = false;
                    System.out.println("notifying odd");
                    numberI.notify();
                }

                try {
                    System.out.println("waiting even !");
                    numberI.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
