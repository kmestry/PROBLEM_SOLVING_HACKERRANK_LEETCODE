package com.datastructure_2_studyplan_leetcode.day1;

import java.util.*;

public class ThreeSumTwoPointer {

    public List<List<Integer>> threeSum(int[] nums) {

        Arrays.sort(nums);
        Set<List<Integer>> set = new HashSet<>();

        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            int l = i + 1;
            int r = nums.length - 1;

            while (l < r) {
                if (nums[l] + nums[r] == -num) {
                    set.add(Arrays.asList(num, nums[l], nums[r]));
                    l++;
                    r--;
                } else if (nums[l] + nums[r] > -num) {
                    r--;
                } else {
                    l++;
                }
            }
        }

        return new ArrayList<>(set);
    }
}
