package com.datastructure_studyplan_leetcode;

public class MaximumSubArray {

    public int maxSubArray(int[] nums) {

        int result = nums[0];
        int currSum = nums[0];

        for (int i = 1; i < nums.length; i++) {
            currSum += nums[i];

            if (nums[i] > currSum) {
                result = Math.max(result, nums[i]);
                currSum = nums[i];
            } else {
                result = Math.max(result, currSum);
            }


        }

        return result;
    }
}
