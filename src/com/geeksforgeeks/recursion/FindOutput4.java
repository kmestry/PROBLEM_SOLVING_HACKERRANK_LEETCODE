package com.geeksforgeeks.recursion;

public class FindOutput4 {

    static void fun(int n) {
        if (n == 0)
            return;

        fun(n / 2);

        System.out.println(n % 2);

    }

    public static void main(String[] args) {
        fun(10);
    }
}
