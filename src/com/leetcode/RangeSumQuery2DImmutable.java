package com.leetcode;

public class RangeSumQuery2DImmutable {

    int[][] prefixSum;
    int row;
    int col;

    public RangeSumQuery2DImmutable(int[][] matrix) {

        if (matrix != null) {

            this.row = matrix.length;
            if (row > 0)
                this.col = matrix[0].length;

            if (row > 0 && col > 0) {

                this.prefixSum = new int[row][col];
                initializePrefixSumMatrix(prefixSum, matrix);
            }
        }

    }

    public static void main(String[] args) {
        new RangeSumQuery2DImmutable(new int[][]{
                {3, 0, 1, 4, 2},
                {5, 6, 3, 2, 1},
                {1, 2, 0, 1, 5},
                {4, 1, 0, 1, 7},
                {1, 0, 3, 0, 5}})
                .sumRegion(2, 1, 4, 3);
    }

    private void initializePrefixSumMatrix(int[][] prefixSum, int[][] matrix) {
        //0,0
        prefixSum[0][0] = matrix[0][0];

        //1st row
        for (int i = 0; i < 1; i++) {
            for (int j = 1; j < col; j++) {
                prefixSum[i][j] = matrix[i][j] + prefixSum[i][j - 1];
            }
        }

        //1st col
        for (int i = 1; i < row; i++) {
            for (int j = 0; j < 1; j++) {
                prefixSum[i][j] = matrix[i][j] + prefixSum[i - 1][j];
            }
        }

        //inner.
        for (int i = 1; i < row; i++) {
            for (int j = 1; j < col; j++) {
                prefixSum[i][j] = matrix[i][j] + prefixSum[i - 1][j] + prefixSum[i][j - 1] - prefixSum[i - 1][j - 1];
            }
        }

    }

    public int sumRegion(int row1, int col1, int row2, int col2) {

        int result = 0;

        result += prefixSum[row2][col2];

        if (row1 > 0) {
            result -= prefixSum[row1 - 1][col2];
        }
        if (col1 > 0) {
            result -= prefixSum[row2][col1 - 1];
        }
        if (row1 > 0 && col1 > 0) {
            result += prefixSum[row1 - 1][col1 - 1];
        }

        return result;

    }
}
