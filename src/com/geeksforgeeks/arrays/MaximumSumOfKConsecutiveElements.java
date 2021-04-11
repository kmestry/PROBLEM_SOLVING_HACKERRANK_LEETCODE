package com.geeksforgeeks.arrays;

public class MaximumSumOfKConsecutiveElements {
    public static void main(String[] args) {

        MaximumSumOfKConsecutiveElements maximumSumOfKConsecutiveElements = new MaximumSumOfKConsecutiveElements();
        int res = maximumSumOfKConsecutiveElements.maxSum(new int[]{1, 8, 30, -5, 20, 7}, 3);
        System.out.println("res = " + res);
    }

    //sliding window technique
    private int maxSum(int[] array, int k) {
        int windowSum = 0;

        for (int i = 0; i < k; i++) {
            windowSum += array[i];
        }

        int windowLeft = 1;
        int windowRight = k;  // 0 index so minus 1
        int maxSum = windowSum;
        while (windowRight < array.length) {
            windowSum = windowSum - array[windowLeft - 1] + array[windowRight];
            maxSum = Math.max(maxSum, windowSum);
            windowLeft++;
            windowRight++;
        }

        return maxSum;
    }
}
