package com.leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SortTheMatrixDiagonally {
    int maxRow;
    int maxCol;

    public static void main(String[] args) {

        new SortTheMatrixDiagonally().diagonalSort(new int[][]{{3, 3, 1, 1}, {2, 2, 1, 2}, {1, 1, 1, 2}});
    }


    public int[][] diagonalSort(int[][] mat) {
        maxRow = mat.length;
        maxCol = mat[0].length;
        int[][] result = new int[maxRow][maxCol];

        int startRow = 0;
        int startCol = 0;

        while (startCol < maxCol) {
            helper(startRow, startCol, mat, result);
            startCol++;
        }
        startCol = 0;
        while (startRow < maxRow) {
            helper(startRow, startCol, mat, result);
            startRow++;
        }


        return result;

    }

    private void helper(int row, int col, int[][] mat, int[][] result) {

        List<Integer> list = new ArrayList<>();
        int oldRow = row;
        int oldCol = col;
        int newRow = row;
        int newCol = col;
        while (oldRow < maxRow && oldCol < maxCol) {
            list.add(mat[oldRow][oldCol]);
            oldRow++;
            oldCol++;
        }


        Collections.sort(list);

        int index = 0;
        while (newRow < maxRow && newCol < maxCol) {
            result[newRow][newCol] = list.get(index);

            index++;
            newRow++;
            newCol++;
        }

    }


}
