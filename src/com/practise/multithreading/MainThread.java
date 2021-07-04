package com.practise.multithreading;

public class MainThread {
    public static void main(String[] args) {
        ThreeThreadCommunication thread1 = new ThreeThreadCommunication(1);
        ThreeThreadCommunication thread2 = new ThreeThreadCommunication(2);
        ThreeThreadCommunication thread3 = new ThreeThreadCommunication(0);

        Thread t1 = new Thread(thread1, "Thread no 1");
        Thread t2 = new Thread(thread2, "Thread no 2");
        Thread t3 = new Thread(thread3, "Thread no 3");

        t1.start();
        t2.start();
        t3.start();
    }
}
