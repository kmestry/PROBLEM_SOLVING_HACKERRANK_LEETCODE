package com.datastructure_2_studyplan_leetcode.day4;

public class SearchIn2DMatrix2 {

    public boolean searchMatrix(int[][] matrix, int target) {

        int r = matrix.length;
        for (int i = 0; i < r; i++) {

            boolean res = binarySearch(i, matrix, target);
            if (res) return true;
        }
        return false;

    }

    private boolean binarySearch(int r, int[][] matrix, int target) {

        int lp = 0;
        int rp = matrix[0].length - 1;

        // System.out.println("lp =" + lp);
        // System.out.println("rp =" + rp);
        // System.out.println("r =" + r);
        while (lp <= rp) {
            int mid = (lp + rp) / 2;

            if (matrix[r][mid] == target) {
                return true;
            } else if (target > matrix[r][mid]) {
                lp = mid + 1;
            } else {
                rp = mid - 1;
            }
        }

        return false;
    }
}
