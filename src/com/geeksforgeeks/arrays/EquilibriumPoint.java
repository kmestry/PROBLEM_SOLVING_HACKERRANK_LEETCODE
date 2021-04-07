package com.geeksforgeeks.arrays;

public class EquilibriumPoint {

    public static int equilibriumPoint(long[] arr, int n) {

        // Your code here
        if (arr.length == 1) return 1; // first element , as there is only 1 element present.

        for (int i = 1; i < arr.length; i++) {

            int leftSum = 0;
            int rightSum = 0;


            for (int j = 0; j < i; j++) {
                leftSum += arr[j];
            }

            for (int j = i + 1; j < arr.length; j++) {
                rightSum += arr[j];
            }

            if (leftSum == rightSum) return i + 1;
        }

        return -1;
    }
}
