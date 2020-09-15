package com.leetcode;

public class MinCostClimbingStairsRecursion {

    int minSum = Integer.MAX_VALUE;


    public int minCostClimbingStairs(int[] cost) {

        helper(cost, 0, 0);
        helper(cost, 1, 0);


        return minSum;
    }

    private int helper(int[] cost, int index, int currentSum) {

        if (index > cost.length) return 0;
        if (index == cost.length) {
            minSum = Math.min(currentSum, minSum);
            return minSum;
        }


        helper(cost, index + 1, currentSum + cost[index]);
        helper(cost, index + 2, currentSum + cost[index]);


        return minSum;

    }
}
