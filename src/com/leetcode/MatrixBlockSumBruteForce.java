package com.leetcode;

public class MatrixBlockSumBruteForce {

    public int[][] matrixBlockSum(int[][] mat, int K) {


        int[][] result = new int[mat.length][mat[0].length];

        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[0].length; j++) {

                int lowerRow = i - K;
                int upperRow = i + K;
                int lowerCol = j - K;
                int upperCol = j + K;

                int sum = 0;
                for (int l = lowerRow; l <= upperRow; l++) {
                    for (int m = lowerCol; m <= upperCol; m++) {

                        if (l < mat.length && l >= 0 && m < mat[0].length && m >= 0) {
                            sum += mat[l][m];
                        }


                    }
                }

                result[i][j] = sum;

            }
        }

        return result;

    }
}
