package com.leetcode;

public class SearchIn2DMatrix2 {


    public boolean searchMatrix(int[][] matrix, int target) {


        int rowSize = matrix.length;
        if (rowSize == 0) return false;
        int columnSize = matrix[0].length;
        if (columnSize == 0) return false;

        int rowPointer = 0;
        int columnPointer = columnSize - 1;

        int initialPointer = -1; // start pointer from first row last column

        while (rowPointer < matrix.length && columnPointer >= 0) {

            initialPointer = matrix[rowPointer][columnPointer];

            if (target == initialPointer) return true;

            else if (target > initialPointer) {
                rowPointer++;
            } else if (target < initialPointer) {
                columnPointer--;
            }

        }

        return false;
    }


}
