package com.leetcode;

import java.util.Arrays;

public class PerfectSquaresOptimized {

    public int numSquares(int n) {
        int[] dp = new int[n + 1];
        Arrays.fill(dp, -1);
        return helper(n, dp);
    }


    int helper(int n, int[] dp) {

        if (n == 0) return 0;
        if (dp[n] != -1) return dp[n];
        int min = Integer.MAX_VALUE;
        for (int i = 1; i * i <= n; i++) {
            int curr = helper(n - i * i, dp) + 1;
            min = Math.min(min, curr);
        }

        dp[n] = min;
        return min;
    }
}
