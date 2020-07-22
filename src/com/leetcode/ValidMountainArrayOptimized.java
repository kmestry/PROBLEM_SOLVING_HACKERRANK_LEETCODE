package com.leetcode;

// 1 2 3 4 5 3 2 1
public class ValidMountainArrayOptimized {


    public static void main(String[] args) {

        boolean result = validMountainArray(new int[]{0, 3, 2, 1});
        System.out.println("result = " + result);
    }

    public static boolean validMountainArray(int[] A) {

        if (A.length < 3) return false;
        int peakIndex = 0;
        for (int i = 0; i < A.length - 1; i++) {
            if (A[i + 1] <= A[i]) {
                peakIndex = i;
                break;
            }
        }
        if (peakIndex == 0 || peakIndex == A.length - 1) {
            return false;
        }

        for (int i = peakIndex; i < A.length - 1; i++) {

            if (A[i] <= A[i + 1]) {
                return false;
            }
        }

        return true;
    }
}
