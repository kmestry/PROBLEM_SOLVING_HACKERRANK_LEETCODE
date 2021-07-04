package com.blind_list_75.matrix;

import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix {

    public static void main(String[] args) {
        SpiralMatrix spiralMatrix = new SpiralMatrix();
        spiralMatrix.spiralOrder(new int[][]{{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}});
    }

    // 1 2  3   4
    // 5 6  7   8
    // -1 -2 -3 -4
    // 9 10 11 12
    public List<Integer> spiralOrder(int[][] matrix) {

        List<Integer> list = new ArrayList<>();

        int totalRows = matrix.length - 1;
        int totalCols = matrix[0].length - 1;
        int firstRow = 0;
        int firstCol = 0;
        boolean[][] visited = new boolean[totalRows + 1][totalCols + 1];

        while (firstRow <= totalRows && firstCol <= totalCols) {
            for (int i = firstCol; i <= totalCols; i++) {
                if (visited[firstRow][i]) continue;
                list.add(matrix[firstRow][i]);
                visited[firstRow][i] = true;
            }
            firstRow++;
            for (int i = firstRow; i <= totalRows; i++) {
                if (visited[i][totalCols]) continue;
                list.add(matrix[i][totalCols]);
                visited[i][totalCols] = true;
            }
            totalCols--;

            // 1 2 3
            // 4 5 6
            // 7 8 9

            for (int i = totalCols; i >= firstCol; i--) {
                if (visited[totalRows][i]) continue;
                list.add(matrix[totalRows][i]);
                visited[totalRows][i] = true;
            }
            totalRows--;

            for (int i = totalRows; i >= firstRow; i--) {
                if (visited[i][firstCol]) continue;
                list.add(matrix[i][firstCol]);
                visited[i][firstCol] = true;
            }
            firstCol++;
        }
        return list;
    }
}
