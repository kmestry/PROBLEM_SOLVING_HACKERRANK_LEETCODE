package com.geeksforgeeks.arrays;

public class MaximumSumCircularSubArrayOptimized {

    public static void main(String[] args) {

        MaximumSumCircularSubArrayOptimized maximumSumCircularSubArrayOptimized = new MaximumSumCircularSubArrayOptimized();
        int result = maximumSumCircularSubArrayOptimized.maxSumCircularSubArray(new int[]{8, -4, 3, -5, 4});
        System.out.println("result = " + result);
    }

    private int maxSumCircularSubArray(int[] array) {
        //logic is find max normal sub array sum, max circular subarray sum. take max of both.

        int maxNormalSubArraySum = maxSubArraySum(array);

        if (maxNormalSubArraySum < 0) return maxNormalSubArraySum;
        int arraySum = 0;

        for (int i = 0; i < array.length; i++) {
            arraySum += array[i];

            array[i] = -array[i];

        }

        int maxCircularSubArraySum = arraySum + maxSubArraySum(array);

        return Math.max(maxCircularSubArraySum, maxNormalSubArraySum);

    }


    private int maxSubArraySum(int[] array) {
        //kadanes algorithm;

        // 8, -4 ,3 ,-5 ,4
        int maxTillNow = array[0];
        int maxSum = array[0];

        for (int i = 1; i < array.length; i++) {

            maxTillNow = Math.max(maxTillNow + array[i], array[i]);
            maxSum = Math.max(maxSum, maxTillNow);
        }

        return maxSum;

    }
}
