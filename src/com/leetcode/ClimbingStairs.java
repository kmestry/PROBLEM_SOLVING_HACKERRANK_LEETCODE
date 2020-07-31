package com.leetcode;

public class ClimbingStairs {
    public static void main(String[] args) {
        int result = climbStairs(5);
    }

    public static int climbStairs(int n) {


        if (n == 1) {
            return 1;
        }

        int[] cache = new int[n + 1];
        cache[1] = 1; //
        cache[2] = 2;

        for (int i = 3; i <= n; i++) {
            cache[i] = cache[i - 1] + cache[i - 2];
        }

        return cache[n];

    }
}
