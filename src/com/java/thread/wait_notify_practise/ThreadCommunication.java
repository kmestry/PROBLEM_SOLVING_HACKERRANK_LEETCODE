package com.java.thread.wait_notify_practise;

public class ThreadCommunication {

    public static void main(String[] args) throws InterruptedException {
        NumberI i = new NumberI();
        i.setEven(true);
        i.startVal = 0;
        i.endVal = 100;
        PrintEven printEven = new PrintEven(i);
        PrintOdd printOdd = new PrintOdd(i);

        Thread t1 = new Thread(printEven, "even Thread");


        Thread t2 = new Thread(printOdd, "odd Thread");

        //Thread.sleep(3000);
        t2.start();
        Thread.sleep(3000);
        t1.start();


    }
}
