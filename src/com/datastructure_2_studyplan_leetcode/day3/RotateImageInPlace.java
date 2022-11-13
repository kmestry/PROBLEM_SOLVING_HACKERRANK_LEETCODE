package com.datastructure_2_studyplan_leetcode.day3;

public class RotateImageInPlace {

    public static void main(String[] args) {
        new RotateImageInPlace().rotate(new int[][]{
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}});
    }

    public void rotate(int[][] matrix) {

        //transpose
        int rl = matrix.length;
        int cl = matrix[0].length;

        for (int i = 0; i < rl; i++) {
            for (int j = i; j < cl; j++) {

                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;

            }
        }


        int currRow = 0;

        while (currRow < rl) {
            int l = 0;
            int r = cl - 1;
            while (l < r) {
                int temp = matrix[currRow][l];
                matrix[currRow][l] = matrix[currRow][r];
                matrix[currRow][r] = temp;
                l++;
                r--;
            }
            currRow++;
        }

    }
}
