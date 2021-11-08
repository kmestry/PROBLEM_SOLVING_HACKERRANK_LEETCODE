package com.leetcode_restart;

public class Matrix01 {
    public static void main(String[] args) {
        new Matrix01().updateMatrix(new int[][]{
                {0, 0, 0},
                {0, 1, 0},
                {1, 1, 1}});
    }

    public int[][] updateMatrix(int[][] mat) {

        boolean[][] visited = new boolean[mat.length][mat[0].length];
        int[][] result = new int[mat.length][mat[0].length];

        for (int i = 0; i < mat.length; i++) {
            System.arraycopy(mat[i], 0, result[i], 0, mat[0].length);
        }
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[0].length; j++) {
                if (mat[i][j] == 1) {
                    int minDist = helper(mat, i, j, visited);
                    result[i][j] = minDist;
                } else {
                    result[i][j] = 0;
                }
            }
        }

        return result;

    }

    private int helper(int[][] mat, int r, int c, boolean[][] visited) {

        if (r < 0 || c < 0 || r >= mat.length || c >= mat[0].length || visited[r][c]) {
            return 100000;
        }
        if (mat[r][c] == 0) {
            return 0;
        }

        visited[r][c] = true;

        int dir1 = helper(mat, r + 1, c, visited);
        int dir2 = helper(mat, r - 1, c, visited);
        int dir3 = helper(mat, r, c + 1, visited);
        int dir4 = helper(mat, r, c - 1, visited);
        visited[r][c] = false;
        return Math.min(dir1, Math.min(dir2, Math.min(dir3, dir4))) + 1;
    }
}
