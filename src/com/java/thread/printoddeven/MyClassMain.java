package com.java.thread.printoddeven;

public class MyClassMain {
    public static void main(String[] args) {
        RunnableTask p1 = new RunnableTask(0);
        RunnableTask p2 = new RunnableTask(1);
        RunnableTask p3 = new RunnableTask(2);

        Thread t1 = new Thread(p1, "thread p1");
        Thread t2 = new Thread(p2, "thread p2");
        Thread t3 = new Thread(p3, "thread p3");

        t1.start();
        t2.start();
        t3.start();
        //
    }

}
