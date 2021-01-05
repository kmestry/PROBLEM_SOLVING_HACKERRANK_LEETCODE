package com.leetcode;

public class ReachANumber {

    public int reachNumber(int target) {

        return helper(0, Math.abs(target), 0);

    }

    private int helper(int source, int target, int steps) {

        if (Math.abs(source) > target) {
            return Integer.MAX_VALUE;
        }

        if (Math.abs(source) == target) {
            return steps;
        }

        int case1 = helper(source + steps + 1, target, steps + 1);
        int case2 = helper(source - steps - 1, target, steps + 1);

        int res = Math.min(case1, case2);

        return res;
    }
}
