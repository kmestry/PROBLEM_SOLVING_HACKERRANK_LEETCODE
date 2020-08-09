package com.leetcode;

public class SubArraySumEqualsKOptimized {

    public static void main(String[] args) {
        new SubArraySumEqualsKOptimized().subarraySum(new int[]{10, 5, 7, 1, 2, 5, 3}, 15);
    }

    public int subarraySum(int[] nums, int k) {

        int[] prefixSum = new int[nums.length];
        prefixSum[0] = nums[0];
        int runningSum = prefixSum[0];
        for (int i = 1; i < nums.length; i++) {
            prefixSum[i] = runningSum + nums[i];
            runningSum = prefixSum[i];
        }

        int resultCounter = 0;

        //1st loop
        for (int i = 0; i < prefixSum.length; i++) {
            if (k == prefixSum[i]) {
                resultCounter++;
            }
        }

        //2nd sliding window;
        int leftPointer = 0;
        int rightPointer = 1;
        int windowSize = 2;
        while (windowSize <= prefixSum.length) {
            while (rightPointer < prefixSum.length) {
                if (Math.abs(prefixSum[rightPointer] - prefixSum[leftPointer]) == k) {
                    resultCounter++;
                }
                leftPointer++;
                rightPointer++;
            }
            windowSize++;
            leftPointer = 0;
            rightPointer = windowSize - 1;
        }

        return resultCounter;
    }
}