package com.leetcode_restart;

public class SearchIn2DMatrixOptimized {

    public boolean searchMatrix(int[][] matrix, int target) {

        int maxRow = matrix.length;
        int maxCol = matrix[0].length;
        int left = 0;
        int right = maxRow * maxCol - 1;

        while (left <= right) {
            int mid = (left + right) / 2;
            System.out.println("mid= " + mid);
            int element = matrix[mid / maxCol][mid % maxCol];
            System.out.println("mid= mid / maxCol " + mid / maxCol);
            System.out.println("mid= mid % maxCol " + mid % maxCol);
            System.out.println("element " + element);

            if (element == target) {
                return true;
            } else if (target > element) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return false;
    }
}
