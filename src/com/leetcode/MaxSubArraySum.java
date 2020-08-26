package com.leetcode;

public class MaxSubArraySum {

    public static void main(String[] args) {
        new MaxSubArraySum().maxSubArray(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4});
    }

    public int maxSubArray(int[] nums) {

        int maxSum = nums[0];
        int runningSum = maxSum;

        for (int i = 1; i < nums.length; i++) {
            runningSum = Math.max(nums[i] + runningSum, nums[i]);
            maxSum = Math.max(runningSum, maxSum);
        }

        return maxSum;
    }
}
