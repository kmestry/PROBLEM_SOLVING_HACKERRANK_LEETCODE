package com.geeksforgeeks.arrays;

public class MaximumSumCircularApproach2 {

    public static void main(String[] args) {
        MaximumSumCircularApproach2 maximumSumCircularApproach2 = new MaximumSumCircularApproach2();
        int result = maximumSumCircularApproach2.maxSumCircularSubArray(new int[]{8, -4, 3, -5, 4});
        System.out.println("result = " + result);
    }

    private int maxSumCircularSubArray(int[] array) {
        //find normal array maximum subarray sum using kadanes.
        //find min  subarray sum using kadanes with minimum subarray sum.
        //subtract totalsum - minSubarray sum to get max circular subarray sum.
        //max of normal sub array sum and max of circular sub array sum.

        int normalMaxSubArraySum = maxSumSubArrayKadanes(array);

        if (normalMaxSubArraySum < 0) return normalMaxSubArraySum;

        int totalSum = 0;
        for (int j : array) {
            totalSum += j;
        }

        int minSubArraySum = minSumSubArrayKadanes(array);

        int circularMaxSubArraySum = totalSum - minSubArraySum;

        int result = Math.max(normalMaxSubArraySum, circularMaxSubArraySum);

        return result;

    }

    private int maxSumSubArrayKadanes(int[] array) {

        int maxTillNow = array[0];
        int result = array[0];

        for (int i = 1; i < array.length; i++) {
            maxTillNow = Math.max(maxTillNow + array[i], array[i]);
            result = Math.max(maxTillNow, result);
        }

        return result;
    }

    private int minSumSubArrayKadanes(int[] array) {
        int minTillNow = array[0];
        int result = array[0];

        for (int i = 1; i < array.length; i++) {
            minTillNow = Math.min(minTillNow + array[i], array[i]);
            result = Math.min(minTillNow, result);
        }
        return result;
    }
}
