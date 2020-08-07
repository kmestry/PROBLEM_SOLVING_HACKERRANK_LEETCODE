package com.leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class SetMatrixZeros {

    public static void main(String[] args) {

        // new SetMatrixZeros().setZeroes(new int[][]{{1, 1, 1}, {1, 0, 1}, {1, 1, 1}});
        new SetMatrixZeros().setZeroes(new int[][]{{0, 1, 2, 0}, {3, 4, 5, 2}, {1, 3, 1, 5}});


    }

    public void setZeroes(int[][] matrix) {

        Set<List<Integer>> rowColumnSet = new HashSet<>();
        int rows = matrix.length;
        int columns = matrix[0].length;

        for (int i = 0; i < rows; i++) {

            for (int j = 0; j < columns; j++) {
                List<Integer> checkList = new ArrayList<>();
                checkList.add(i);
                checkList.add(j);
                if (matrix[i][j] == 0 && !rowColumnSet.contains(checkList)) {


                    for (int l = 0; l < columns; l++) {
                        if (matrix[i][l] != 0) {
                            matrix[i][l] = 0;
                            List<Integer> rowColumn = new ArrayList<>();
                            rowColumn.add(i);
                            rowColumn.add(l);
                            rowColumnSet.add(rowColumn);
                        }
                    }

                    for (int k = 0; k < rows; k++) {
                        if (matrix[k][j] != 0) {
                            matrix[k][j] = 0;
                            List<Integer> rowColumn = new ArrayList<>();
                            rowColumn.add(k);
                            rowColumn.add(j);
                            rowColumnSet.add(rowColumn);
                        }
                    }


                }

            }
        }


        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                System.out.print(matrix[i][j] + " ");
            }
        }

    }
}
