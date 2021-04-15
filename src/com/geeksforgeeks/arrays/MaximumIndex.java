package com.geeksforgeeks.arrays;

public class MaximumIndex {
    static int maxIndexDiff(int[] arr, int n) {

        // Your code here
        int maxIndexDiff = Integer.MIN_VALUE;

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                if (arr[i] <= arr[j]) {
                    maxIndexDiff = Math.max(maxIndexDiff, j - i);
                }
            }
        }
        return maxIndexDiff;
    }
}
