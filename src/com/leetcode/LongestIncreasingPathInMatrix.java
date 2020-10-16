package com.leetcode;

public class LongestIncreasingPathInMatrix {

    int prev;
    boolean isInsideHelper = false;

    public static void main(String[] args) {
        new LongestIncreasingPathInMatrix().longestIncreasingPath(new int[][]
                {{3, 4, 5}, {3, 2, 6}, {2, 2, 1}});
    }

    /*
    *
    *
  [3,4,5],
  [3,2,6],
  [2,2,1]*/

    public int longestIncreasingPath(int[][] matrix) {

        int row = matrix.length;
        int col = matrix[0].length;

        int lip = Integer.MIN_VALUE;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                prev = matrix[i][j];
                lip = Math.max(lip, helper(matrix, row, col, i, j, Integer.MIN_VALUE));
            }
        }
        return lip;
    }

    private int helper(int[][] matrix, int row, int col, int i, int j, int prev) {

        if (i >= row || j >= col || i < 0 || j < 0) return 0;

        int curr = matrix[i][j];

        if (curr <= prev) {
            return 0;
        }


        int down = 1 + helper(matrix, row, col, i + 1, j, curr);
        int top = 1 + helper(matrix, row, col, i - 1, j, curr);
        int left = 1 + helper(matrix, row, col, i, j - 1, curr);
        int right = 1 + helper(matrix, row, col, i, j + 1, curr);


        int maxPath = Math.max(down, Math.max(top, Math.max(left, right)));

        return maxPath;
    }
}
