package com.leetcode;

import java.util.ArrayList;
import java.util.List;

public class DiagonalTraverse {
    public static void main(String[] args) {
    /*  [ 1, 2, 3 ],
        [ 4, 5, 6 ],
        [ 7, 8, 9 ]*/
// pattern : ////
        //new DiagonalTraverse().findDiagonalOrder(new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}});
        new DiagonalTraverse().findDiagonalOrder(new int[][]{{1, 2}, {3, 4}});
    }

    //hint : reverse diagonal with odd number count.
    public int[] findDiagonalOrder(int[][] matrix) {

        if (matrix.length == 0) {
            return new int[]{};
        }
        int[] result = new int[matrix.length * matrix[0].length];
        int rowCounter = 0;
        int colCounter = 0;
        int index = 0;

        int rIncrementer = 0;
        int cIncrementer = 0;
        int diagonal = 1;
        while (index < result.length) {

            rowCounter = rIncrementer;
            colCounter = cIncrementer;
            boolean isDiagonal = false;
            List<Integer> diagonalList = null;
            if (diagonal % 2 != 0) {
                diagonalList = new ArrayList<>();
                isDiagonal = true;
            }

            while (rowCounter >= 0
                    &&
                    colCounter >= 0
                    &&
                    rowCounter < matrix.length
                    &&
                    colCounter < matrix[0].length) {

                if (isDiagonal) {
                    diagonalList.add(matrix[rowCounter][colCounter]);
                } else {
                    result[index] = matrix[rowCounter][colCounter];
                    index++;
                }
                rowCounter++;
                colCounter--;
            }
            //reverse diagonal
            if (diagonalList != null && !diagonalList.isEmpty()) {
                for (int i = diagonalList.size() - 1; i >= 0; i--) {
                    result[index] = diagonalList.get(i);
                    index++;
                }

            }
            cIncrementer++;
            if (cIncrementer >= matrix[0].length) {
                cIncrementer = matrix[0].length - 1;
                rIncrementer++;
            }
            diagonal++;
        }


        return result;
    }
}
