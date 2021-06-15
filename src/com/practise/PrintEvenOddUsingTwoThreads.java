package com.practise;

public class PrintEvenOddUsingTwoThreads {

    static int N; // max number till u want to print value;
    int counter = 1;

    public static void main(String[] args) {

        N = 10;
        PrintEvenOddUsingTwoThreads pt = new PrintEvenOddUsingTwoThreads();

        Thread t1 = new Thread(pt::evenPrint, "EVen THREAD");
        Thread t2 = new Thread(pt::oddPrint, "ODD THREAD");

        t1.start();
        t2.start();
    }

    public void oddPrint() {

        synchronized (this) {
            while (counter < N) {
                while (counter % 2 == 0) {
                    try {
                        wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

                System.out.println("Value printed by : " + Thread.currentThread().getName() + " value is " + counter);
                counter++;
                notify();
            }
        }
    }

    public void evenPrint() {
        synchronized (this) {
            while (counter < N) {
                while (counter % 2 == 1) {
                    try {
                        wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

                System.out.println("Value printed by : " + Thread.currentThread().getName() + " value is " + counter);
                counter++;
                notify();
            }
        }
    }


}
