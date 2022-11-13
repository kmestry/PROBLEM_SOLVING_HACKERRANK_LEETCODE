package com.datastructure_2_studyplan_leetcode.day1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSumWithoutSet {

    // -2 0 0 2 2 : Example to understand skipping of elements
    public List<List<Integer>> threeSum(int[] nums) {

        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();


        for (int i = 0; i < nums.length; i++) {

            if (i == 0 || nums[i] != nums[i - 1]) {
                int num = nums[i];

                int l = i + 1;
                int r = nums.length - 1;

                while (l < r) {
                    if (nums[l] + nums[r] == -num) {
                        result.add(Arrays.asList(num, nums[l], nums[r]));
                        while (l < r && nums[l] == nums[l + 1]) l++;
                        while (l < r && nums[r] == nums[r - 1]) r--;
                        l++;
                        r--;
                    } else if (nums[l] + nums[r] > -num) {
                        r--;
                    } else {
                        l++;
                    }
                }

            }
        }

        return result;
    }
}


//-4 -1 -1 0 1 2

