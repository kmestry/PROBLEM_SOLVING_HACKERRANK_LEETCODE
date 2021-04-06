package com.geeksforgeeks.arrays;

public class MaximumOccurredIntegerPrefixSum {

    public static void main(String[] args) {

    }

    public static int maxOccurred(int[] L, int[] R, int n, int maxx) {
        int[] arr = new int[1000000];

        for (int i = 0; i < L.length; i++) {
            arr[L[i]]++;
            arr[R[i] + 1]--;
        }

        int maxPrefixSum = 0;

        int sumTillNow = arr[0];

        int element = 0;
        for (int i = 1; i < arr.length; i++) {
            sumTillNow += arr[i];

            if (sumTillNow > maxPrefixSum) {
                element = i;
                maxPrefixSum = sumTillNow;
            }
        }

        return element;
    }
}
