package com.leetcode;

public class FibonacciNumber {

    public static void main(String[] args) {
        int result = new FibonacciNumber().fibDP(10);
        System.out.println("result = " + result);
    }

    public int fib(int N) {

        if (N == 0)
            return 0;
        if (N == 1)
            return 1;

        int[] cache = new int[N + 1];

        cache[0] = 0;
        cache[1] = 1;

        if (cache[N] != 0)
            return cache[N];

        return fib(N - 1) + fib(N - 2);


    }

    public int fibDP(int N) {


        int[] cache = new int[N + 1];
        cache[0] = 0;
        cache[1] = 1;

        for (int i = 2; i <= N; i++) {
            cache[i] = cache[i - 1] + cache[i - 2];
        }

        return cache[N];
    }
}
