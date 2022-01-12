package com.datastructure_2_studyplan_leetcode.day1;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class MajorityElement {
    public int majorityElement(int[] nums) {

        int freq = nums.length / 2;
        if (nums.length == 1) return nums[0];
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                map.put(nums[i], map.get(nums[i]) + 1);
                if (map.get(nums[i]) > freq) {
                    return nums[i];
                }
            } else {
                map.put(nums[i], 1);
            }
        }

        return -1;
    }

    public int majorityElementSorting(int[] nums) {

        Arrays.sort(nums);

        return nums[nums.length / 2];
    }
}
