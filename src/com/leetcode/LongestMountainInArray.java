package com.leetcode;

public class LongestMountainInArray {

    public int longestMountain(int[] A) {

        int longestMountain = 0;

        if (A.length < 3) {
            return longestMountain;
        }


        for (int i = 1; i < A.length - 1; i++) {

            if (A[i] > A[i + 1] && A[i] > A[i - 1]) {

                int left = i - 1;
                int right = i + 1;

                while (left > 0 && A[left] > A[left - 1]) {
                    left--;
                }

                while (right < A.length - 1 && A[right] > A[right + 1]) {
                    right++;
                }

                longestMountain = Math.max(right - left + 1, longestMountain);
            }
        }

        return longestMountain;

    }
}
