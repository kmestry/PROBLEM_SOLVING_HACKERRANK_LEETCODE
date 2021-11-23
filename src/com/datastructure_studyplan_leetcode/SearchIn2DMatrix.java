package com.datastructure_studyplan_leetcode;

public class SearchIn2DMatrix {

    public boolean searchMatrix(int[][] matrix, int target) {

        int rows = matrix.length;
        int cols = matrix[0].length;

        int rowToSearch = -1;
        for (int i = 0; i < rows; i++) {
            if (target >= matrix[i][0] && target <= matrix[i][cols - 1]) {
                rowToSearch = i;
                break;
            }
        }

        if (rowToSearch == -1) return false;

        return binarySearch(matrix, rowToSearch, target);

    }

    private boolean binarySearch(int[][] matrix, int row, int target) {

        int left = 0;
        int right = matrix[0].length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
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
