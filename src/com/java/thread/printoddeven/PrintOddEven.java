package com.java.thread.printoddeven;

public class PrintOddEven {

    private int max;
    private int number;
    private boolean isOdd;

    public static void main(String[] args) {
        PrintOddEven obj = new PrintOddEven();
        obj.setMax(20);
        obj.setOdd(true);
        obj.setNumber(1);

        Thread t1 = new Thread(() -> obj.printEven());
        Thread t2 = new Thread(() -> obj.printOdd());

        t1.start();
        t2.start();


       /* try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }*/

    }

    public int getMax() {
        return max;
    }

    public void setMax(int max) {
        this.max = max;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public boolean isOdd() {
        return isOdd;
    }

    public void setOdd(boolean odd) {
        isOdd = odd;
    }

    public synchronized void printOdd() {

        while (number < max) {

            while (!isOdd) {
                try {
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("number = in odd = " + number);
            number++;
            isOdd = false;
            notify();
        }

    }

    public synchronized void printEven() {
//        try {
//            Thread.sleep(1000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
        while (number < max) {

            while (isOdd) {
                try {
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            System.out.println("number = in even = " + number);
            number++;
            isOdd = true;
            notify();

        }
    }
}
