package com.leetcode_restart;

import org.jetbrains.annotations.NotNull;

import java.util.HashMap;
import java.util.Map;

public class TwoSumEfficient {

    public int @NotNull [] twoSum(int @NotNull [] nums, int target) {

        Map<Integer, Integer> map = new HashMap<>();
        int[] result = new int[2];
        for (int i = 0; i < nums.length; i++) {

            if (map.containsKey(nums[i])) {
                result[0] = map.get(nums[i]);
                result[1] = i;
                break;
            } else {
                map.put(target - nums[i], i);
            }

        }

        return result;
    }
}
