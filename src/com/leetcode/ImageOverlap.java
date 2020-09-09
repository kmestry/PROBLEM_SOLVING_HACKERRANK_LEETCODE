package com.leetcode;

public class ImageOverlap {

    public static void main(String[] args) {
        ImageOverlap obj = new ImageOverlap();
        obj.largestOverlap(new int[][]{{1, 1, 0}, {0, 1, 0}, {0, 1, 0}}, new int[][]{{0, 0, 0}, {0, 1, 1}, {0, 0, 1}});
    }

    private int getMatchCount(int[][] A, int[][] B, int startRowA, int startColA) {
        int count = 0;
        int startRowB = 0;
        int startColB = 0;
        for (int i = startRowA; i < A.length; i++) {
            startColB = 0;
            for (int j = startColA; j < A[0].length; j++) {
                if (A[i][j] == 1 && A[i][j] == B[startRowB][startColB]) {
                    count++;
                }
                startColB++;
            }
            startRowB++;
        }
        return count;
    }

    public int largestOverlap(int[][] A, int[][] B) {
        int maxCount = 0;

        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < A[0].length; j++) {

                maxCount = Math.max(maxCount, getMatchCount(A, B, i, j));

                maxCount = Math.max(maxCount, getMatchCount(B, A, i, j));
            }
        }

        return maxCount;
    }
}
