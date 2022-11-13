package com.datastructure_2_studyplan_leetcode.day5;

import java.util.HashMap;
import java.util.Map;

public class SubArraySumEqualsKOptimized {

    public static void main(String[] args) {
        new SubArraySumEqualsKOptimized().subarraySum(new int[]{1, 2, 3}, 3);
    }

    public int subarraySum(int[] nums, int k) {

        int sum = 0;
        int result = 0;

        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        for (int num : nums) {
            sum += num;

            if (map.containsKey(sum - k)) {
                result += map.get(sum - k);
            }
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }

        return result;
    }
}
