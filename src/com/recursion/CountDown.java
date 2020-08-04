package com.recursion;

public class CountDown {

    public static void main(String[] args) {
        new CountDown().countDown(10);
    }

    public void countDown(int number) {

        if (number == 0) {
            System.out.println("HOORAY!!");
            return;
        }

        System.out.println("number = " + number);
        number = number - 1;

        countDown(number);
    }
}

