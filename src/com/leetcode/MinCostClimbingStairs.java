package com.leetcode;

public class MinCostClimbingStairs {


    public static void main(String[] args) {

        int res = new MinCostClimbingStairs().minCostClimbingStairs(new int[]{10, 15, 20});
        System.out.println("res = " + res);
    }

    public int minCostClimbingStairs(int[] cost) {

        int[] dp = new int[cost.length];
        //Arrays.fill(dp, -1);
        int path1 = helper(cost, 0, dp);
        int path2 = helper(cost, 1, dp);


        return Math.min(path1, path2);
    }

    private int helper(int[] cost, int index, int[] dp) {

        if (index >= cost.length) return 0;

        if (dp[index] > 0) return dp[index];
        int path1 = cost[index] + helper(cost, index + 1, dp);
        int path2 = cost[index] + helper(cost, index + 2, dp);


        return dp[index] = Math.min(path1, path2);

    }
}

