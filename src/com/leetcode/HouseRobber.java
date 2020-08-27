package com.leetcode;

import java.util.HashMap;
import java.util.Map;

public class HouseRobber {

    Map<Integer, Integer> map = new HashMap<>();

    public static void main(String[] args) {
        new HouseRobber().rob(new int[]{2, 1, 1, 2});
    }

    public int rob(int[] nums) {

        return helper(nums, nums.length - 1);


    }

    private int helper(int[] nums, int index) {

        if (index < 0) return 0;

        if (map.get(index) != null) {
            return map.get(index);
        }

        int robberyDone = helper(nums, index - 2) + nums[index];
        int robberyNotDone = helper(nums, index - 1);

        int result = Math.max(robberyDone, robberyNotDone);

        map.put(index, result);

        return result;
    }
}
