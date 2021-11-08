package com.leetcode_restart;

import java.util.HashMap;
import java.util.Map;

public class HouseRobber {

    public int rob(int[] nums) {

        int max = Integer.MIN_VALUE;

        Map<Integer, Integer> map = new HashMap<>();
        return helper(nums, 0, map);

    }

    private int helper(int[] nums, int index, Map<Integer, Integer> map) {

        if (index >= nums.length) {
            return 0;
        }
        if (map.containsKey(index)) {
            return map.get(index);
        }

        int doNothing = helper(nums, index + 1, map);
        int robHouse = helper(nums, index + 2, map) + nums[index];

        //System.out.println(" " + doNothing);
        //System.out.println(" :: "+ robHouse);
        int max = Math.max(doNothing, robHouse);
        map.put(index, max);
        return max;


    }
}
