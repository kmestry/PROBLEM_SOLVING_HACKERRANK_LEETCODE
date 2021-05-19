package com.java.thread.even_odd_thread_practise;

public class ThreadCommunication {
    public static void main(String[] args) {

        Number number = new Number();
        number.start = 0;
        number.end = 10;


        PrintOdd printOdd = new PrintOdd(number);
        PrintEven printEven = new PrintEven(number);

        Thread t1 = new Thread(printEven, "EVEN THREAD!~");
        Thread t2 = new Thread(printOdd, "ODD THREAD!~");

        t1.start();
        t2.start();
    }
}
