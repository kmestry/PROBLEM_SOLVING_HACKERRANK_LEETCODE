package com.leetcode.twentythree;

public class NumberOfIslands {


    public int numIslands(char[][] grid) {
        int res = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1') {
                    helper(grid, i, j);
                    res++;
                }
            }
        }
        return res;

    }

    private void helper(char[][] grid, int r, int c) {

        if (r >= grid.length || r < 0 || c >= grid[0].length || c < 0 || grid[r][c] != '1') return;

        if (grid[r][c] == '1') {
            grid[r][c] = '2';

            helper(grid, r + 1, c);
            helper(grid, r - 1, c);
            helper(grid, r, c + 1);
            helper(grid, r, c - 1);

        }


    }
}
