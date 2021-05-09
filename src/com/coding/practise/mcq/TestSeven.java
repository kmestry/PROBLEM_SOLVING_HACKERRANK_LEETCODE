package com.coding.practise.mcq;

public class TestSeven extends Thread {

    private static int x;

    //https://stackoverflow.com/questions/20594281/multithreading-threadseven-extends-thread
    public static void main(String[] args) {
        TestSeven testSeven = new TestSeven();
        testSeven.start();
    }

    public synchronized void doThings() {
        System.out.println("x = " + x);
        int current = x;
        current++;
        x = current;
        System.out.println("current = " + current);
    }

    public void run() {
        doThings();
    }
}
