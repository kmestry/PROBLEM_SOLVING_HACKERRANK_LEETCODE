package com.leetcode;

import java.util.Arrays;

public class KsmallestElementInSortedMatrix {

    public int kthSmallest(int[][] matrix, int k) {


        int r = matrix.length;
        int c = matrix[0].length;
        if (r == 1 && c == 1) return matrix[0][0];
        int[] array = new int[r * c + 1];

        int index = 1;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {

                array[index] = matrix[i][j];
                index++;


            }
        }

        Arrays.sort(array);
        // for(int i = 0 ; i < array.length; i++){
        //     System.out.println(array[i]);
        // }

        return array[k];
    }
}
