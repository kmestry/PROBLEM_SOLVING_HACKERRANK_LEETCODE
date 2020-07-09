package com.leetcode;

import java.util.HashMap;

public class TwoSumHashMap1 {

    // 2, 7, 11, 15  target=9
    public static void main(String[] args) {

    }

    public static int[] twoSum(int[] nums, int target) {

        HashMap<Integer, Integer> numberIndexHashMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (numberIndexHashMap.containsKey(target - nums[i])) {
                return new int[]{i, numberIndexHashMap.get(target - nums[i])};
            }
            numberIndexHashMap.put(nums[i], i);
        }
        return null;
    }
}
