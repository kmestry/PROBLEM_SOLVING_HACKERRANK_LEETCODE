package com.leetcode;

public class SpiralMatrix2 {

    public static void main(String[] args) {
        new SpiralMatrix2().generateMatrix(4);
    }

    public int[][] generateMatrix(int n) {

        int[][] result = new int[n][n];

        int count = 1;
        int row = 0;
        int col = 0;
        int iteration = 1; // once first spiral is filled we need to move inwards. first spiral is all
        // the boundary elements of matrix.

        //idea is to move right,down,left,top..accordingly increment row and decrement columns.
        //quite tricky to understand without debugging in IDE.

        while (count <= n * n) {
            while (col < n) {
                if (result[row][col] == 0) {
                    result[row][col] = count;
                    count++;

                }
                col++;
            }
            col = col - iteration;
            if (checkIfCountReached(n, count)) break;

            while (row < n) {
                if (result[row][col] == 0) {
                    result[row][col] = count;
                    count++;

                }
                row++;
            }


            row = row - iteration;
            if (checkIfCountReached(n, count)) break;
            while (col > -1) {
                if (result[row][col] == 0) {
                    result[row][col] = count;
                    count++;

                }
                col--;
            }

            col = col + iteration;

            if (checkIfCountReached(n, count)) break;
            while (row > -1) {
                if (result[row][col] == 0) {
                    result[row][col] = count;
                    count++;

                }
                row--;
            }

            row = row + iteration;
            if (checkIfCountReached(n, count)) break;


            //1st cycle complete
            row++;  // after first iteration the next filling of elements start from row 1, col 1.
            col++;
            iteration++;
        }

        return result;
    }

    private boolean checkIfCountReached(int n, int count) {
        return count > n * n;
    }
}
