package com.leetcode;

import java.util.HashMap;
import java.util.Map;

public class TwoSumTwoPassHashTable {

    public static void main(String[] args) {
        int[] result = new TwoSumTwoPassHashTable().twoSum(new int[]{3, 3}, 6);

        for (int i : result) {
            System.out.println("i = " + i);
        }
    }

    public int[] twoSum(int[] nums, int target) {

        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {

            map.put(nums[i], i);

        }
        // 2 1


        // 3 1

        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            //important check is whether the complement is not equal to i .
            if (map.containsKey(complement) && map.get(complement) != i) {
                return new int[]{i, map.get(complement)};

            }
        }

        return new int[]{};


    }
}
