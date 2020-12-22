package com.leetcode;

import java.util.Arrays;

public class SmallestRange2 {

    public static void main(String[] args) {
        new SmallestRange2().smallestRangeII(new int[]{1, 3, 6}, 3);
    }

    public int smallestRangeII(int[] A, int k) {
        Arrays.sort(A);
        int n = A.length;
        int max = A[n - 1] - k;
        int min = A[0] + k;
        int res = A[n - 1] - A[0];
        for (int i = 0; i < A.length - 1; i++) {
            int new_max = Math.max(max, A[i] + k);
            int new_min = Math.min(min, A[i + 1] - k);
            res = Math.min(res, new_max - new_min);
        }

        return res;
    }

}
