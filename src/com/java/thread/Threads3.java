package com.java.thread;

public class Threads3 implements Runnable {

    public static void main(String[] args) {
        Thread t = new Thread(new Threads3());
        t.run();
        t.run();
        t.start();
    }

    @Override
    public void run() {
        System.out.print("running");
    }
}
