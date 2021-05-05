package com.geeksforgeeks.searching;

import java.util.Arrays;

public class SortedArrayTripletSumEqualsTarget {

    public static boolean find3Numbers(int[] A, int n, int X) {

        Arrays.sort(A);
        // Your code Here
        for (int i = 0; i < A.length; i++) {
            if (isPair(A, i + 1, A.length - 1, X - A[i])) {
                return true;
            }
        }
        return false;


    }

    private static boolean isPair(int[] A, int low, int high, int target) {

        while (low < high) {
            int sum = A[low] + A[high];

            if (sum == target) {
                return true;
            } else if (sum > target) {
                high--;
            } else {
                low++;
            }
        }
        return false;
    }
}
