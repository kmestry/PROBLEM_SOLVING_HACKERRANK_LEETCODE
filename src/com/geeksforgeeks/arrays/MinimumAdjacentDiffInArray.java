package com.geeksforgeeks.arrays;

public class MinimumAdjacentDiffInArray {
    public static int minAdjDiff(int[] arr, int n) {

        // Your code here

        int minAdjDiff = Integer.MAX_VALUE;

        for (int i = 1; i < arr.length; i++) {
            minAdjDiff = Math.min(minAdjDiff, Math.abs(arr[i] - arr[i - 1]));
        }
        minAdjDiff = Math.min(minAdjDiff, Math.abs(arr[0] - arr[arr.length - 1]));

        return minAdjDiff;
    }
}
