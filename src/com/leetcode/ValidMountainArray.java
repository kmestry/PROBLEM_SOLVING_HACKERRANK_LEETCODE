package com.leetcode;

public class ValidMountainArray {

    public static void main(String[] args) {
        boolean result = validMountainArray(new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9});
        System.out.println("result = " + result);
    }

    public static boolean validMountainArray(int[] A) {

        if (A.length < 3) {
            return false;
        }
        int maxIndex = findPeak(A);


        if (maxIndex == 0 || maxIndex == A.length - 1) {
            return false;
        }


        if (maxIndex - 1 == 0) {
            if (A[0] >= A[maxIndex]) {
                return false;
            }
        }

        for (int i = 0; i < maxIndex - 1; i++) {
            if (A[i] >= A[i + 1]) {
                return false;
            }
        }

        if (maxIndex + 1 == A.length - 1) {
            if (A[maxIndex] <= A[A.length - 1]) {
                return false;
            }
        }

        for (int i = maxIndex + 1; i < A.length - 1; i++) {
            if (A[i] <= A[i + 1]) {
                return false;
            }
        }
        return true;

    }

    public static int findPeak(int[] A) {

        int max = 0;
        int index = 0;

        for (int i = 0; i < A.length; i++) {
            if (A[i] > max) {
                max = A[i];
                index = i;
            }
        }

        return index;
    }
}
