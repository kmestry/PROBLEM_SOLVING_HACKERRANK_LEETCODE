package com.practise;

public class MaximumSumSubArrayKadanesAlgo {

    public int maxSubArray(int[] nums) {

        int maxSum = Integer.MIN_VALUE;

        int pointer = 0;
        int currSum = 0;

        while (pointer < nums.length) {
            int element = nums[pointer];
            currSum += element;
            if (currSum < 0) {
                maxSum = Math.max(currSum, maxSum);
                currSum = 0;
            } else {
                maxSum = Math.max(currSum, maxSum);
            }
            pointer++;
        }

        return maxSum;

    }
}
