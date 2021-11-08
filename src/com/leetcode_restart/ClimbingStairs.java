package com.leetcode_restart;

import java.util.HashMap;
import java.util.Map;

public class ClimbingStairs {

    public int climbStairs(int n) {

        Map<Integer, Integer> dpMap = new HashMap<>();
        return helper(n, 0, dpMap);
    }

    private int helper(int n, int steps, Map<Integer, Integer> dpMap) {

        if (steps > n) {
            return 0;
        }
        if (steps == n) {
            return 1;
        }
        if (dpMap.containsKey(steps))
            return dpMap.get(steps);

        int oneStep = helper(n, steps + 1, dpMap);
        int twoStep = helper(n, steps + 2, dpMap);

        int tot = oneStep + twoStep;

        dpMap.put(steps, tot);

        return tot;

    }
}
