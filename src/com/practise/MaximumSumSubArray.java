package com.practise;

public class MaximumSumSubArray {

    //brute force
    public int maxSubArray(int[] nums) {

        int maxSum = Integer.MIN_VALUE;
        int currSum = 0;
        for (int i = 0; i < nums.length; i++) {
            currSum = nums[i];
            maxSum = Math.max(currSum, maxSum);
            for (int j = i + 1; j < nums.length; j++) {
                currSum += nums[j];
                maxSum = Math.max(currSum, maxSum);
            }
        }
        maxSum = Math.max(currSum, maxSum);
        return maxSum;

    }
}
