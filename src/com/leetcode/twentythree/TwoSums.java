package com.leetcode.twentythree;

import java.util.HashMap;
import java.util.Map;

public class TwoSums {
    public int[] twoSum(int[] nums, int target) {

        Map<Integer, Integer> map = new HashMap<>();
        int[] res = new int[2];

        for (int i = 0; i < nums.length; i++) {

            if (map.containsKey(nums[i])) {
                res[0] = map.get(nums[i]);
                res[1] = i;
                break;
            } else {
                map.put(target - nums[i], i);
            }
        }
        return res;

    }
}
