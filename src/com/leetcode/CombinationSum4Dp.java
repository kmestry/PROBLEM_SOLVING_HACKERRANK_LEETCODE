package com.leetcode;

import java.util.HashMap;
import java.util.Map;

public class CombinationSum4Dp {

    Map<Integer, Integer> map = new HashMap<>();

    public static void main(String[] args) {
        int result = new CombinationSum4Dp().combinationSum4(new int[]{1, 2, 3}, 4);
        System.out.println("result = " + result);
    }

    public int combinationSum4(int[] nums, int target) {
        return helper(nums, target, 0, 0);
    }

    private int helper(int[] nums, int target, int sum, int index) {

        if (sum > target || index >= nums.length) {
            return 0;
        }
        if (sum == target) {
            return 1;
        }
        Integer key = sum;
        if (map.containsKey(key)) {
            return map.get(key);
        }

        int count = 0;


        for (int i = 0; i < nums.length; i++) {
            count += helper(nums, target, sum + nums[i], index);
        }
        map.put(sum, count);

        return count;

    }
}
