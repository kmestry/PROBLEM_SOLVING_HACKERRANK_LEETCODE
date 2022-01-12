package com.datastructure_2_studyplan_leetcode.day1;

import java.util.*;

public class ThreeSum {

    public List<List<Integer>> threeSum(int[] nums) {

        Set<List<Integer>> set = new HashSet<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                for (int k = j + 1; k < nums.length; k++) {
                    if (nums[i] + nums[j] + nums[k] == 0) {
                        List<Integer> list = new ArrayList<>();
                        list.add(nums[i]);
                        list.add(nums[j]);
                        list.add(nums[k]);
                        set.add(list);
                    }
                }
            }
        }

        return new ArrayList<>(set);
    }
}
