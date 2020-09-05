package com.leetcode;

import java.util.HashMap;
import java.util.Map;

public class PartitionSubsetEqualsSum {

    Map<String, Boolean> map = new HashMap<>();

    public boolean canPartition(int[] nums) {

        int total = 0;
        for (int i : nums) {
            total += i;
        }
        if (total % 2 != 0) return false;

        return helper(nums, 0, 0, total);

    }


    private boolean helper(int[] nums, int index, int sum, int total) {

        if (index >= nums.length) return false;
        if (sum == total - sum) {
            //System.out.println("inside");
            return true;
        }

        String key = sum + "^" + index;
        if (map.containsKey(key))
            return map.get(key);

        boolean result = helper(nums, index + 1, sum + nums[index], total) ||
                helper(nums, index + 1, sum, total);

        map.put(key, result);

        return result;

    }
}
