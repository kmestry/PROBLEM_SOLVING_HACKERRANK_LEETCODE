package com.leetcode;

public class FibonacciNumber {

    public static void main(String[] args) {
       /* int result = new FibonacciNumber().fib(10);
        System.out.println("result = " + result);*/

        int[] cache = new int[51];
        cache[0] = 0;
        cache[1] = 1;
        int result = new FibonacciNumber().fib(40, cache);
        System.out.println("result = " + result);
    }


    public int fib(int N, int[] cache) {

        if (N <= 1)
            return N;
        if (cache[N] != 0) {
            return cache[N];
        }

        cache[N] = fib(N - 1, cache) + fib(N - 2, cache);

        return cache[N];

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
