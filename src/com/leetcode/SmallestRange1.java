package com.leetcode;

public class SmallestRange1 {

    public static void main(String[] args) {

        int result = new SmallestRange1().smallestRangeI(new int[]{1, 3, 6}, 3);
        System.out.println("result = " + result);
    }

    public int smallestRangeI(int[] A, int k) {

        int min = A[0];
        int max = A[0];

        for (int j : A) {
            min = Math.min(min, j);
            max = Math.max(max, j);
        }
        return min + k >= max - k ? 0 : (max - k) - (min + k);
    }
}
