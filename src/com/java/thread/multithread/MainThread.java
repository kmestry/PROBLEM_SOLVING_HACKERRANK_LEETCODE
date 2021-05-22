package com.java.thread.multithread;

public class MainThread {
    public static void main(String[] args) {
        PrintNumbersUsingThreeThreads printNumbersUsingThreeThreads1 = new PrintNumbersUsingThreeThreads(1);
        PrintNumbersUsingThreeThreads printNumbersUsingThreeThreads3 = new PrintNumbersUsingThreeThreads(0);
        PrintNumbersUsingThreeThreads printNumbersUsingThreeThreads2 = new PrintNumbersUsingThreeThreads(2);

        Thread thread1 = new Thread(printNumbersUsingThreeThreads1, "thread 1");
        Thread thread2 = new Thread(printNumbersUsingThreeThreads2, "thread 2");
        Thread thread3 = new Thread(printNumbersUsingThreeThreads3, "thread 3");


        thread1.start();

        thread2.start();
        thread3.start();


    }
}
