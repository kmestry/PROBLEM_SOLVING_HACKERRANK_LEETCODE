package com.java.thread;

public class Bank {
    int amount = 100000;

    synchronized void withdraw(int amount) {
        System.out.println("withdrawing amount!");

        if (amount > this.amount) {
            try {
                System.out.println("Less money in bank..add balance to withdraw!!");
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        this.amount = this.amount - amount;
        System.out.println("withdrawn amount successfully! updated balance is :" + this.amount);

    }

    synchronized void deposit(int amount) {
        System.out.println("depositing money!");
        this.amount += amount;
        System.out.println("Successfully deposited amount!");
        notify();
    }
}
