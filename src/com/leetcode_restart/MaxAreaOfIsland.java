package com.leetcode_restart;

public class MaxAreaOfIsland {

    public int maxAreaOfIsland(int[][] grid) {

        int maxArea = 0;
        int rows = grid.length;
        int cols = grid[0].length;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {

                if (grid[i][j] == 1) {
                    maxArea = Math.max(maxArea, helper(grid, i, j));
                }
            }
        }
        return maxArea;
    }

    private int helper(int[][] grid, int i, int j) {

        if (i < 0 || j < 0 || i >= grid.length || j >= grid[0].length || grid[i][j] == 0) {
            return 0;
        }

        grid[i][j] = 0;

        return 1 + helper(grid, i + 1, j) + helper(grid, i - 1, j) + helper(grid, i, j + 1) + helper(grid, i, j - 1);
    }
}
