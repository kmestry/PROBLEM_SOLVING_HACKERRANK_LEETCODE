package com.java.thread;

public class BankMain {

    public static void main(String[] args) {

        Bank bank = new Bank();

        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                bank.withdraw(200000);
            }
        });

        t1.start();

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                bank.deposit(10000000);
            }
        });
        t2.start();

    }
}
