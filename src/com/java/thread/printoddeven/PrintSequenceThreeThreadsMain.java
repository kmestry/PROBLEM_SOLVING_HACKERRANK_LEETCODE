package com.java.thread.printoddeven;

public class PrintSequenceThreeThreadsMain {

    public static void main(String[] args) {
        PrintSequenceThreeThreads p1 = new PrintSequenceThreeThreads(0);
        PrintSequenceThreeThreads p2 = new PrintSequenceThreeThreads(1);
        PrintSequenceThreeThreads p3 = new PrintSequenceThreeThreads(2);

        Thread t1 = new Thread(p1, "thread p1");
        Thread t2 = new Thread(p2, "thread p2");
        Thread t3 = new Thread(p3, "thread p3");

        t1.start();
        t2.start();
        t3.start();
    }

}
