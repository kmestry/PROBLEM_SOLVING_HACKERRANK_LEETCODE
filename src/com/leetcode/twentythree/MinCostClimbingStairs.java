package com.leetcode.twentythree;

public class MinCostClimbingStairs {

    public static void main(String[] args) {
        MinCostClimbingStairs minCostClimbingStairs = new MinCostClimbingStairs();
        minCostClimbingStairs.minCostClimbingStairs(new int[]{10, 15, 20});
    }

    public int minCostClimbingStairs(int[] cost) {

        int cost1 = helper(cost, 0);
        int cost2 = helper(cost, 1);

        return Math.min(cost1, cost2);
    }

    private int helper(int[] cost, int index) {

        if (index >= cost.length) return 0;

        int cost1 = cost[index] + helper(cost, index + 1);
        int cost2 = cost[index] + helper(cost, index + 2);

        return Math.min(cost1, cost2);
    }
}
