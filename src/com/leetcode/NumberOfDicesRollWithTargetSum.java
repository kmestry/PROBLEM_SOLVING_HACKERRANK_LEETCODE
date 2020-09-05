package com.leetcode;

import java.util.HashMap;
import java.util.Map;

public class NumberOfDicesRollWithTargetSum {

    Map<String, Integer> map = new HashMap<>();
    int MOD = 1000000000 + 7;

    public int numRollsToTarget(int d, int f, int target) {


        return helper(0, d, f, target);
    }


    private int helper(int sum, int d, int f, int target) {

        if (d < 0) {
            return 0;
        }

        if (d == 0 && sum == target) {
            return 1;
        }
        String key = sum + "," + d;
        Integer val = map.get(key);
        if (val != null) return val;


        int count = 0;


        for (int i = 1; i <= f; i++) {
            count += helper(sum + i, d - 1, f, target);
            count = count % MOD;
            map.put(key, count);
        }
        //count += helper(sum , list, d  , target, index + 1);

        return count;

    }
}
