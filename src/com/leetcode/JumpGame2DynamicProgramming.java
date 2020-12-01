package com.leetcode;

import java.util.HashMap;
import java.util.Map;

public class JumpGame2DynamicProgramming {

    Map<Integer, Integer> dpMap = new HashMap<>();

    public static void main(String[] args) {
        int result = new JumpGame2DynamicProgramming().jump(new int[]{2, 3, 1, 1, 4});
        System.out.println("result = " + result);
    }

    public int jump(int[] nums) {
        return helper(0, nums);
    }

    private int helper(int index, int[] nums) {
        if (index >= nums.length) {
            return Integer.MAX_VALUE;
        }
        Integer key = index;
        if (dpMap.containsKey(key))
            return dpMap.get(key);

        if (index == nums.length - 1) {
            return 0;
        }

        int choices = nums[index];
        int endChoice = choices + index;
        int minValue = Integer.MAX_VALUE - 1;
        for (int i = index + 1; i <= endChoice; i++) {

            int val = helper(i, nums);
            minValue = Math.min(val, minValue);

        }


        dpMap.put(index, minValue + 1);

        return minValue + 1;


    }
}
