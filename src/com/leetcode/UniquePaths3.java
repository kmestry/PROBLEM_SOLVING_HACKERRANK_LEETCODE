package com.leetcode;

public class UniquePaths3 {

    public int uniquePathsIII(int[][] grid) {

        int startIndexRow = -1;
        int startIndexColumn = -1;
        int countOfNonObstaclePath = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    startIndexRow = i;
                    startIndexColumn = j;
                }
                if (grid[i][j] == 0) {
                    countOfNonObstaclePath++;
                }
            }
        }

        return helper(grid, countOfNonObstaclePath, startIndexRow, startIndexColumn);

    }


    private int helper(int[][] grid, int countOfNonObstaclePath, int row, int column) {

        if (row < 0 || column < 0 || row >= grid.length || column >= grid[0].length || grid[row][column] == -1) {
            return 0;
        }

        if (grid[row][column] == 2) {
            return countOfNonObstaclePath == -1 ? 1 : 0;
        }

        grid[row][column] = -1; // visited

        countOfNonObstaclePath--;  //decrease zero count

        int totalPaths = helper(grid, countOfNonObstaclePath, row + 1, column)
                + helper(grid, countOfNonObstaclePath, row, column + 1)
                + helper(grid, countOfNonObstaclePath, row - 1, column)
                + helper(grid, countOfNonObstaclePath, row, column - 1);


        grid[row][column] = 0;  // reset visited to 0
        countOfNonObstaclePath++; // increase zero count

        return totalPaths;
    }
}
