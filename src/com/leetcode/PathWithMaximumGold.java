package com.leetcode;

public class PathWithMaximumGold {

    int maxSum = Integer.MIN_VALUE;

    public static void main(String[] args) {
        int result = new PathWithMaximumGold().getMaximumGold(new int[][]{{0, 6, 0}, {5, 8, 7}, {0, 9, 0}});
        System.out.println("result = " + result);
    }

    public int getMaximumGold(int[][] grid) {

        int row = -1;
        int col = -1;
        for (int i = 0; i < grid.length; i++) {

            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] != 0) {
                    row = i;
                    col = j;
                    maxSum = Math.max(helper(row, col, grid, new boolean[grid.length][grid[0].length]), maxSum);
                }
            }
        }


        //System.out.println(row + "-- " + col);

        return maxSum;
    }

    private int helper(int row, int column, int[][] grid, boolean[][] isVisited) {
        if (row >= grid.length || column >= grid[0].length || row < 0 || column < 0 || grid[row][column] == 0 || isVisited[row][column])
            return 0;


        //System.out.println("=");

        isVisited[row][column] = true;
        int down = helper(row + 1, column, grid, isVisited);
        int up = helper(row - 1, column, grid, isVisited);
        int right = helper(row, column + 1, grid, isVisited);
        int left = helper(row, column - 1, grid, isVisited);

        isVisited[row][column] = false;

        return Math.max(left, Math.max(right, Math.max(up, down))) + grid[row][column];

    }
}
