package com.geeksforgeeks.arrays;

public class EquilibriumPointOptimized {

    public static void main(String[] args) {
        EquilibriumPointOptimized.equilibriumPoint(new long[]{1, 3, 5, 2, 2}, 5);
    }

    
    public static int equilibriumPoint(long[] arr, int n) {

        long leftSum = 0;

        long totalSum = 0;

        for (long num : arr) {
            totalSum += num;
        }

        int index = 0;
        long sumTillNow =  0;
        for (long num : arr) {
            sumTillNow += num;
            long rightSum = totalSum - sumTillNow;


            if (rightSum == leftSum) {
                return index + 1;
            } else {
                leftSum += num;
            }

            index++;
        }

        return -1;
    }
}
