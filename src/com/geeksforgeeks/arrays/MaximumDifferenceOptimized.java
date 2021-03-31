package com.geeksforgeeks.arrays;

public class MaximumDifferenceOptimized {
    public static void main(String[] args) {

        MaximumDifferenceOptimized maximumDifferenceOptimized = new MaximumDifferenceOptimized();
        int result = maximumDifferenceOptimized.maxDifference(new int[]{2, 3, 10, 6, 4, 8, 1});
    }

    private int maxDifference(int[] arr) {
        int minVal = arr[0];
        int maxDiff = arr[1] - arr[0];

        for (int i = 1; i < arr.length; i++) {

            maxDiff = Math.max(maxDiff, arr[i] - minVal);
            minVal = Math.min(minVal, arr[i]);
        }

        return maxDiff;
    }
}
