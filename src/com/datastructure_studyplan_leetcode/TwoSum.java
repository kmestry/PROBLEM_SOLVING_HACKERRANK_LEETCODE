package com.datastructure_studyplan_leetcode;

import java.util.HashMap;
import java.util.Map;

public class TwoSum {

    public int[] twoSum(int[] nums, int target) {

        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {

            map.put(nums[i], i);

        }
        int[] result = new int[2];

        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i]) && (i != map.get(target - nums[i]))) {
                result[0] = i;
                result[1] = map.get(target - nums[i]);
                return result;
            }
        }


        return result;
    }
}
