package com.blind_list_75.matrix;

public class RotateImageOptimized {

    public static void main(String[] args) {
        RotateImageOptimized rotateImageOptimized = new RotateImageOptimized();
        rotateImageOptimized.rotate(new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}});
    }


    // 1 2 3
    // 4 5 6
    // 7 8 9

    // 1 4 7
    // 2 5 8
    // 3 6 9
    public void rotate(int[][] matrix) {

        int r = matrix.length;
        int c = matrix[0].length;
        //formula to transpose matrix. change rows and columns
        for (int i = 0; i < r; i++) {
            for (int j = i; j < c; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }

        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c / 2; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[i][matrix[0].length - 1 - j];
                matrix[i][matrix[0].length - 1 - j] = temp;
            }
        }

    }


}
