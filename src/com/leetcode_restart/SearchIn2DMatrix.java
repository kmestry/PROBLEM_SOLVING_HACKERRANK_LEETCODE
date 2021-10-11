package com.leetcode_restart;

public class SearchIn2DMatrix {

    public boolean searchMatrix(int[][] matrix, int target) {

        int row = 0;
        int maxRow = matrix.length;
        int maxCol = matrix[0].length - 1;
        while (row < maxRow) {
            if (target >= matrix[row][0] && target <= matrix[row][maxCol]) {
                return binarySearch(matrix, row, target);
            }
            row++;
        }
        return false;
    }

    private boolean binarySearch(int[][] matrix, int row, int target) {
        //System.out.println("here");
        int left = 0;
        int right = matrix[0].length - 1;


        while (left <= right) {
            int mid = left + (right - left) / 2;
            // System.out.println("mid "+ mid);
            if (matrix[row][mid] == target) {
                return true;
            } else if (target > matrix[row][mid]) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return false;

    }
}
