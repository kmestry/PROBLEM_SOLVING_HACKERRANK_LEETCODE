package com.leetcode;

public class CountNumber1351 {

    public static void main(String[] args) {
        //[[3,2],[-3,-3],[-3,-3],[-3,-3]]
        //int result = countNegatives(new int[][]{{4, 3, 2, -1}, {3, 2, 1, -1}, {1, 1, -1, -2}, {-1, -1, -2, -3}});
        int result = countNegatives(new int[][]{{3, 2}, {-3, -3}, {-3, -3}, {-3, -3}});
        System.out.println("result = " + result);
    }

    public static int countNegatives(int[][] grid) {
        int row = grid.length;
        int col = grid[0].length;
        int counter = 0;

        for (int i = 0; i < row; i++) {
            int[] innerArray = new int[col];
            for (int j = 0; j < col; j++) {
                innerArray[j] = grid[i][j];
            }
            //edge case
            if (innerArray[0] < 0) {
                counter += innerArray.length;
            } else if (innerArray[innerArray.length - 1] > 0) {
                counter += 0;
            } else {
                int left = 0;
                int right = innerArray.length - 1;
                while (left <= right) {
                    int mid = left + ((right - left) / 2);
                    if (innerArray[mid] >= 0) {
                        left = mid + 1;
                    } else if (innerArray[mid] < 0) {
                        right = mid - 1;
                    }
                }
                counter += innerArray.length - left;
            }
        }
        return counter;
    }
}


