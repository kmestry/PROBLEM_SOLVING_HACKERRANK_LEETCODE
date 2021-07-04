package com.blind_list_75.matrix;

import java.util.ArrayList;
import java.util.List;

public class SpiralMatrixOptimized {


    public static void main(String[] args) {
        SpiralMatrixOptimized spiralMatrixOptimized = new SpiralMatrixOptimized();
       /* List<Integer> list = spiralMatrixOptimized.
                spiralOrder(new int[][]{{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}});*/
        List<Integer> list = spiralMatrixOptimized.
                spiralOrder(new int[][]{{7}, {9}, {6}});
        System.out.println(list);
    }

    //7
    //9
    //6

    // 1 2  3   4
    // 5 6  7   8
    // 9 10 11 12
    public List<Integer> spiralOrder(int[][] matrix) {

        List<Integer> list = new ArrayList<>();
        int firstRow = 0;
        int lastRow = matrix.length - 1;
        int firstCol = 0;
        int lastCol = matrix[0].length - 1;

        while (firstCol <= lastCol && firstRow <= lastRow) {
            for (int i = firstCol; i <= lastCol; i++) {
                list.add(matrix[firstRow][i]);
            }
            firstRow++;

            for (int i = firstRow; i <= lastRow; i++) {
                list.add(matrix[i][lastCol]);
            }
            lastCol--;

            // 1 2  3   4
            // 5 6  7   8
            // 9 10 11 12
            //IMP STEP , recheck the boundary condition after updating lastCol, firstRow
            //in above steps.
            if (firstRow <= lastRow) {
                for (int i = lastCol; i >= firstCol; i--) {
                    list.add(matrix[lastRow][i]);
                }
                lastRow--;
            }

            if (firstCol <= lastCol) {
                for (int i = lastRow; i >= firstRow; i--) {
                    list.add(matrix[i][firstCol]);
                }
                firstCol++;
            }
        }

        return list;
    }
}
