package com.leetcode;

public class MatrixBFS542 {
    /*[[0,0,0],
     [0,1,0],
     [1,1,1]]*/
    public static void main(String[] args) {
        new MatrixBFS542().updateMatrix(new int[][]{{0, 0, 0}, {0, 1, 0}, {1, 1, 1}});
    }

    public int[][] updateMatrix(int[][] matrix) {

        int[][] result = new int[matrix.length][matrix[0].length];

        for (int i = 0; i < matrix.length; i++) {

            for (int j = 0; j < matrix[0].length; j++) {

                int bit = matrix[i][j];

                if (bit == 0) {

                    result[i][j] = 0;

                } else {

                    int val = Integer.MAX_VALUE;

                    for (int l = 0; l < matrix.length; l++) {
                        if (val == 1) break;

                        for (int m = 0; m < matrix[0].length; m++) {

                            int innerBit = matrix[l][m];

                            if (innerBit == 0) {
                                int dist = Math.abs(l - i) + Math.abs(m - j);
                                val = Math.min(dist, val);
                                result[i][j] = val;
                            }

                            if (val == 1) break;

                        }
                    }
                }

            }
        }

        return result;

    }
}
