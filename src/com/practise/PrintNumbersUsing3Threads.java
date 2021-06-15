package com.practise;

public class PrintNumbersUsing3Threads implements Runnable {
    static int N = 10;
    int remainder;
    int counter = 1;

    public PrintNumbersUsing3Threads(int remainder) {
        this.remainder = remainder;
    }

    //thread nums 0,1,2
    // 0 % 3 == 0,  1 % 3== 1, 2% 3 == 2;

    @Override
    public void run() {
        synchronized (this) {
            while (counter < N) {
                while (remainder % 3 != counter) {
                    try {
                        wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println("Value is " + counter + " Printed by thread :" + Thread.currentThread().getName());
                counter++;
                notifyAll();
            }
        }
    }
}
