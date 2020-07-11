package com.leetcode;

public class PeakElement162 {
    public int findPeakElement(int[] nums) {

        for (int i = 0; i < nums.length; i++) {

            if (i == nums.length - 1)
                return i;

            if (nums[i] > nums[i + 1]) {
                return i;
            }
        }
        return 0;

    }
}
