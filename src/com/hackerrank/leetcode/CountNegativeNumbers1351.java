package com.hackerrank.leetcode;

public class CountNegativeNumbers1351 {

    public static int countNegatives(int[][] grid) {

        int negativeNumberCounter = 0;

        for (int i = grid.length - 1; i >= 0; i--) {
            for (int j = grid[0].length - 1; j >= 0; j--) {

                if (grid[i][j] >= 0) {
                    break;
                }

                if (grid[i][j] < 0) {
                    negativeNumberCounter++;
                }

            }
        }
        return negativeNumberCounter;

    }

    //[[5,1,0],[-5,-5,-5]]

    public static void main(String[] args) {
        int result = countNegatives(new int[][]{{5, 1, 0}, {-5, -5, -5}});
        System.out.println("result = " + result);
    }
}
