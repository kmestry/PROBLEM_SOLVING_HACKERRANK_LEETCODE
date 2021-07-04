package com.blind_list_75.matrix;

import java.util.ArrayList;
import java.util.List;

public class SetMatrixZero {

    public void setZeroes(int[][] matrix) {

        int rowLength = matrix.length;
        int colLength = matrix[0].length;
        List<Pair> list = new ArrayList<>();
        for (int i = 0; i < rowLength; i++) {
            for (int j = 0; j < colLength; j++) {
                if (matrix[i][j] == 0) {
                    Pair p = new Pair(i, j);
                    list.add(p);
                }
            }
        }

        for (Pair p : list) {
            int r = p.getRow();
            int c = p.getCol();

            for (int i = c; i < colLength; i++) {
                matrix[r][i] = 0;
            }

            for (int i = 0; i < c; i++) {
                matrix[r][i] = 0;
            }

            for (int i = r; i < rowLength; i++) {
                matrix[i][c] = 0;
            }
            for (int i = 0; i < r; i++) {
                matrix[i][c] = 0;
            }
        }
    }
}


class Pair {
    int row;
    int col;

    Pair(int row, int col) {
        this.row = row;
        this.col = col;
    }

    public int getRow() {
        return this.row;
    }

    public int getCol() {
        return this.col;
    }
}

