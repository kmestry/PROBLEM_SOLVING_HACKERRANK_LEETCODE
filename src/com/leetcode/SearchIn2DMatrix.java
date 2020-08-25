package com.leetcode;

public class SearchIn2DMatrix {

    public static void main(String[] args) {
        boolean result = new SearchIn2DMatrix().searchMatrix(new int[][]{{1, 3, 5, 7}, {10, 11, 16, 20}, {23, 30, 34, 50}}, 3);
        System.out.println("result = " + result);
    }

    public boolean searchMatrix(int[][] matrix, int target) {

        if (matrix.length == 0 || matrix[0].length == 0) return false;

        int rowToSearch = -1;

        for (int i = 0; i < matrix.length; i++) {
            if (target >= matrix[i][0] && target <= matrix[i][matrix[0].length - 1]) {
                rowToSearch = i;
            }
        }

        if (rowToSearch == -1) return false;

        for (int j = 0; j < matrix[0].length; j++) {
            if (matrix[rowToSearch][j] == target) return true;
        }

        return false;
    }

    public boolean searchMatrixOptimized(int[][] matrix, int target) {

        if (matrix.length == 0 || matrix[0].length == 0) return false;

        int rowToSearch = -1;

        for (int i = 0; i < matrix.length; i++) {
            if (target >= matrix[i][0] && target <= matrix[i][matrix[0].length - 1]) {
                rowToSearch = i;
                break;
            }
        }

        if (rowToSearch == -1) return false;


        int leftPointer = 0;
        int rightPointer = matrix[0].length - 1;

        while (leftPointer <= rightPointer) {

            int column = leftPointer + (rightPointer - leftPointer) / 2;

            if (target == matrix[rowToSearch][column]) return true;

            else if (target > matrix[rowToSearch][column]) {
                leftPointer = column + 1;
            } else if (target < matrix[rowToSearch][column]) {
                rightPointer = column - 1;
            }
        }

        return false;
    }
}
