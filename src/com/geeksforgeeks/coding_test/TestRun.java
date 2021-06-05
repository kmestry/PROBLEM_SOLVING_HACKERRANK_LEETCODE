package com.geeksforgeeks.coding_test;

public class TestRun {

    public static void main(String[] args) {
        TestDaemon testDaemon = new TestDaemon();
        testDaemon.setDaemon(false);
        testDaemon.start();
        testDaemon.setDaemon(true);
    }
}
