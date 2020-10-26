package com.leetcode;

public class MatrixBlockSumPrefixSum {


    public static void main(String[] args) {
        new MatrixBlockSumPrefixSum().matrixBlockSum(new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}}, 2);
    }

    public int[][] matrixBlockSum(int[][] mat, int K) {

        int row = mat.length;
        int col = mat[0].length;
        int[][] prefixSum = new int[row][col];
        int[][] result = new int[row][col];

        prefixSum[0][0] = mat[0][0];
        //top boundary row
        for (int i = 0; i < 1; i++) {
            for (int j = 1; j < col; j++) {
                prefixSum[i][j] = mat[i][j] + prefixSum[i][j - 1];
            }
        }

        //boundary col
        for (int i = 1; i < row; i++) {
            for (int j = 0; j < 1; j++) {
                prefixSum[i][j] = mat[i][j] + prefixSum[i - 1][j];
            }
        }

        //inside ..already filled first row and col above.

        for (int i = 1; i < row; i++) {
            for (int j = 1; j < col; j++) {

                prefixSum[i][j] = mat[i][j] + prefixSum[i - 1][j] + prefixSum[i][j - 1] - prefixSum[i - 1][j - 1];

            }
        }

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {

                int r1 = Math.max(0, i - K);
                int c1 = Math.max(0, j - K);
                int r2 = Math.min(row - 1, i + K);
                int c2 = Math.min(col - 1, j + K);

                result[i][j] = prefixSum[r2][c2];

                if (r1 > 0) {
                    result[i][j] -= prefixSum[r1 - 1][c2];
                }

                if (c1 > 0) {
                    result[i][j] -= prefixSum[r2][c1 - 1];
                }
                if (r1 > 0 && c1 > 0) {
                    result[i][j] += prefixSum[r1 - 1][c1 - 1];
                }

            }
        }


        return result;
    }
}
