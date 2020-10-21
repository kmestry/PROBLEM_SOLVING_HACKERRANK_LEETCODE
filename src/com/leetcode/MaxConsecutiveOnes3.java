package com.leetcode;

public class MaxConsecutiveOnes3 {

    public static void main(String[] args) {
        int result = new MaxConsecutiveOnes3().longestOnes(
                new int[]{0, 0, 1, 1}, 2
        );
        System.out.println("result = " + result);
    }

    public int longestOnes(int[] A, int K) {

        int longestOnes = 0;
        for (int i = 0; i < A.length; i++) {
            int maxZeros = K;
            int length = 0;
            for (int j = i; j < A.length; j++) {
                if (maxZeros == 0 && A[j] == 0) {
                    break;
                }
                if (A[j] == 0) {
                    maxZeros--;
                }
                length++;
            }
            longestOnes = Math.max(length, longestOnes);
        }

        return longestOnes;

    }
}
