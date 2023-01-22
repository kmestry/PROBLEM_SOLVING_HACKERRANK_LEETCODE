package com.leetcode.twentythree;

public class Fibonacci {

    public static void main(String[] args) {
        Fibonacci fibonacci = new Fibonacci();
        int res = fibonacci.fib(7);
        System.out.printf(String.valueOf(res));
    }

    public int fib(int n) {
        return helper(n);
    }

    private int helper(int n) {

        if (n == 0 || n == 1) {
            return n;
        }
        int res;
        res = helper(n - 1) + helper(n - 2);
        return res;
    }
}
