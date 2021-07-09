package com.blind_list_75.matrix;

public class RotateImageBruteForce {
    public void rotate(int[][] matrix) {

        int r = matrix.length;
        int c = matrix[0].length;
        int[][] copy = new int[r][c];

        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                copy[i][j] = matrix[i][j];
            }
        }


        int rowC = 0;
        int colC = c - 1;
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                int curr = copy[i][j];
                matrix[rowC][colC] = curr;
                rowC++;
            }
            rowC = 0;
            colC--;
        }
    }

}
