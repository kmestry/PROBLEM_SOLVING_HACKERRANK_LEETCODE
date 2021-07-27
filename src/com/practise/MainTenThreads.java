package com.practise;

public class MainTenThreads {

    public static void main(String[] args) {
        TenThreads tenThreadsZero = new TenThreads(0);

        TenThreads tenThreads1 = new TenThreads(1);
        TenThreads tenThreads2 = new TenThreads(2);
        TenThreads tenThreads3 = new TenThreads(3);
        TenThreads tenThreads4 = new TenThreads(4);
        TenThreads tenThreads5 = new TenThreads(5);

        TenThreads tenThreads6 = new TenThreads(6);
        TenThreads tenThreads7 = new TenThreads(7);
        TenThreads tenThreads8 = new TenThreads(8);
        TenThreads tenThreads9 = new TenThreads(9);

        Thread t1 = new Thread(tenThreadsZero, "T :: 1");
        Thread t2 = new Thread(tenThreads1, "T :: 2");
        Thread t3 = new Thread(tenThreads2, "T :: 3");
        Thread t4 = new Thread(tenThreads3, "T :: 4");
        Thread t5 = new Thread(tenThreads4, "T :: 5");
        Thread t6 = new Thread(tenThreads5, "T :: 6");
        Thread t7 = new Thread(tenThreads6, "T :: 7");
        Thread t8 = new Thread(tenThreads7, "T :: 8");
        Thread t9 = new Thread(tenThreads8, "T :: 9");
        Thread t10 = new Thread(tenThreads9, "T :: 10");

        t1.start();
        t2.start();
        t3.start();
        t4.start();
        t5.start();
        t6.start();
        t7.start();
        t8.start();
        t9.start();
        t10.start();


    }


}
