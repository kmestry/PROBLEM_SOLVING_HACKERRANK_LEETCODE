package com.geeksforgeeks.arrays;

public class MaximumIndexOptimized {
    static int maxIndexDiff(int[] arr, int n) {

        // Your code here
        int maxIndexDiff = Integer.MIN_VALUE;

        for (int i = 0; i < arr.length; i++) {
            for (int j = n - 1; j >= 0; j--) {
                if (arr[j] >= arr[i]) {
                    maxIndexDiff = Math.max(maxIndexDiff, j - i);
                    break;
                }
            }
        }
        return maxIndexDiff;
    }
}
