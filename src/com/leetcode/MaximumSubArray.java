package com.leetcode;

import java.util.Arrays;

public class MaximumSubArray {


    public static void main(String[] args) {

        new MaximumSubArray().maxSubArray(new int[]{1, 2});
    }

    // [-2,1,-3,4,-1,2,1,-5,4],
    public int maxSubArray(int[] nums) {
        int maxSum = Integer.MIN_VALUE;
        //get sum of individual elements i.e. window size 1.
        int maxSumWindowSize1 = Arrays.stream(nums).max().getAsInt();
        if (maxSumWindowSize1 > maxSum) maxSum = maxSumWindowSize1;

        //window Size Loop. we start from 2 window size .
        for (int i = 2; i <= nums.length; i++) {
            int windowSum = findFirstWindowSum(nums, i);
            if (windowSum > maxSum) maxSum = windowSum;

            int leftPointer = 1;
            int rightPointer = i;

            while (rightPointer < nums.length) {
                int sum = windowSum - nums[leftPointer - 1] + nums[rightPointer];
                windowSum = sum;
                if (sum > maxSum) maxSum = sum;
                leftPointer++;
                rightPointer++;
            }
        }


        return maxSum;

    }

    private int findFirstWindowSum(int[] nums, int windowSize) {
        int windowSizeSum = 0;

        for (int i = 0; i < windowSize; i++) {
            windowSizeSum += nums[i];
        }
        return windowSizeSum;


    }
}
