package com.datastructure_2_studyplan_leetcode.day3;

import java.util.ArrayList;
import java.util.List;

public class RotateImage {

    public static void main(String[] args) {
        new RotateImage().rotate(new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}});
    }


    public void rotate(int[][] matrix) {

        List<List<Integer>> list = new ArrayList<>();

        int r = matrix.length;
        int c = matrix[0].length;

        for (int i = 0; i < r; i++) {
            List<Integer> inList = new ArrayList<>();
            for (int j = 0; j < c; j++) {
                inList.add(matrix[i][j]);
            }
            list.add(inList);
        }

        int col = 0;
        int row;
        int index = list.size() - 1;

        while (col < c && index >= 0) {

            int inIndex = 0;
            row = 0;
            while (row < r) {
                matrix[row][col] = list.get(index).get(inIndex);
                row++;
                inIndex++;
            }
            col++;
            index--;

        }
    }
}
