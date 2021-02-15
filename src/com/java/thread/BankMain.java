package com.java.thread;

public class BankMain {

    public static void main(String[] args) throws InterruptedException {

        Bank bank = new Bank();
        bank.wait();

        Thread t1 = new Thread(() -> bank.withdraw(200000));

        t1.start();

        Thread t2 = new Thread(() -> bank.deposit(10000000));
        t2.start();

    }
}
