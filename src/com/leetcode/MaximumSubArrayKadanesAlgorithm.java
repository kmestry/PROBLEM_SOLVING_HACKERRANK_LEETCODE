package com.leetcode;

public class MaximumSubArrayKadanesAlgorithm {

    public static void main(String[] args) {

        new MaximumSubArrayKadanesAlgorithm().maxSubArrayPractise(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4});
    }

    // [-2,1,-3,4,-1,2,1,-5,4],
    public int maxSubArray(int[] nums) {

        int maxSum = nums[0];

        int currentSum = maxSum;

        for (int i = 1; i < nums.length; i++) {
            currentSum = Math.max(nums[i], nums[i] + currentSum);
            maxSum = Math.max(maxSum, currentSum);
        }

        return maxSum;
    }

    public int maxSubArrayPractise(int[] nums) {
        int maxSum = nums[0];
        int currentSum = maxSum;

        for (int i = 1; i < nums.length; i++) {
            currentSum = Math.max(nums[i], nums[i] + currentSum);
            maxSum = Math.max(maxSum, currentSum);

        }

        return maxSum;
    }
}
