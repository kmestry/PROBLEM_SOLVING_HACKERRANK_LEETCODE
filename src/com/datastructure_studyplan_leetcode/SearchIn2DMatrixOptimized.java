package com.datastructure_studyplan_leetcode;

public class SearchIn2DMatrixOptimized {

    public boolean searchMatrix(int[][] matrix, int target) {

        int start = 0;
        int end = matrix.length * matrix[0].length - 1;
        int cols = matrix[0].length;
        while (start <= end) {
            int mid = (start + end) / 2;
            if (target == matrix[mid / cols][mid % cols]) {
                return true;
            } else if (target > matrix[mid / cols][mid % cols]) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }

        return false;
    }
}
