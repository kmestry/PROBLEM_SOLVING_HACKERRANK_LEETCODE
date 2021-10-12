package com.leetcode_restart;

public class MatrixReshape {


    public int[][] matrixReshape(int[][] mat, int r, int c) {

        int rows = mat.length;
        int cols = mat[0].length;

        if (rows * cols != r * c) {
            return mat;
        }

        int[][] result = new int[r][c];

        int rowNum = 0;
        int colNum = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {

                result[rowNum][colNum] = mat[i][j];
                colNum++;
                if (colNum == c) {
                    colNum = 0;
                    rowNum++;
                }
            }
        }

        return result;
    }
}
