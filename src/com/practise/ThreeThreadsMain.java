package com.practise;

import com.java.thread.multithread.PrintNumbersUsingThreeThreads;

public class ThreeThreadsMain {
    public static void main(String[] args) {
        PrintNumbersUsingThreeThreads pt1 = new PrintNumbersUsingThreeThreads(0);
        PrintNumbersUsingThreeThreads pt2 = new PrintNumbersUsingThreeThreads(1);
        PrintNumbersUsingThreeThreads pt3 = new PrintNumbersUsingThreeThreads(2);

        Thread t1 = new Thread(pt1::run, "0 thread");
        Thread t2 = new Thread(pt2::run, "1 thread");
        Thread t3 = new Thread(pt3::run, "2 thread");

        t1.start();
        t2.start();
        t3.start();
    }
}
