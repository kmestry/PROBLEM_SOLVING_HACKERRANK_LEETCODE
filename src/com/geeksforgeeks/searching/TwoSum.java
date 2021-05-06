package com.geeksforgeeks.searching;

import java.util.HashMap;
import java.util.Map;

public class TwoSum {

    public static void main(String[] args) {
        TwoSum twoSum = new TwoSum();
        twoSum.twoSum(new int[]{3, 3}, 6);
    }

    public int[] twoSum(int[] nums, int target) {

        int[] result = new int[2];

        Map<Integer, Integer> map = new HashMap<>();

        int index = 0;
        for (int i : nums) {
            map.put(i, index);
            index++;
        }


        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (map.containsKey(complement) && map.get(complement) != i) {
                result[0] = i;
                result[1] = map.get(complement);
            }
        }

        return result;
    }
}
