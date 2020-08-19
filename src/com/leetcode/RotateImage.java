package com.leetcode;

public class RotateImage {


    public static void main(String[] args) {

        new RotateImage().rotatePractise(new int[][]{{5, 1, 9, 11}, {2, 4, 8, 10}, {13, 3, 6, 7}, {15, 14, 12, 16}});
    }

    //transpose the matrix is swap[i][j] to swap[j][i]

    public void rotate(int[][] matrix) {


        for (int i = 0; i < matrix.length; i++) {
            for (int j = i; j < matrix[0].length; j++) {

                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;

                System.out.println("matrix = " + matrix);
            }
        }

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[i][matrix.length - 1 - j];
                matrix[i][matrix.length - 1 - j] = temp;
            }
        }

        System.out.println("matrix = " + matrix);

    }

    public void rotatePractise(int[][] matrix) {

        //Revers. make first row last row.
        int columnCounter = 0;
        for (int i = 0; i < matrix.length / 2; i++) {

            for (int j = 0; j < matrix[0].length; j++) {
                int temp = matrix[i][j];
                int temp1 = matrix[matrix.length - 1 - columnCounter][j];

                matrix[i][j] = temp1;
                matrix[matrix.length - 1 - columnCounter][j] = temp;


            }
            columnCounter++;
        }

        for (int i = 0; i < matrix.length; i++) {
            for (int j = i; j < matrix[0].length; j++) {
                int temp = matrix[i][j];
                int temp1 = matrix[j][i];

                matrix[i][j] = temp1;
                matrix[j][i] = temp;
            }
        }

    }


}
