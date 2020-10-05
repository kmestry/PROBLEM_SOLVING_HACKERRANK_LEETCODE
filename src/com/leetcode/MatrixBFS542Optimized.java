package com.leetcode;

import java.util.LinkedList;
import java.util.Queue;

public class MatrixBFS542Optimized {

    public int[][] updateMatrix(int[][] matrix) {


        int notVisited = Integer.MAX_VALUE;
        int row = matrix.length;
        int col = matrix[0].length;

        Queue<int[]> queue = new LinkedList<>();

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                int val = matrix[i][j];
                if (val == 0) {
                    queue.offer(new int[]{i, j});
                } else {
                    matrix[i][j] = notVisited;
                }
            }
        }


        while (!queue.isEmpty()) {
            int[] arr = queue.poll();

            int r = arr[0];
            int c = arr[1];

            int curr = matrix[r][c];

            if (r - 1 >= 0) {
                if (matrix[r - 1][c] == notVisited) {
                    matrix[r - 1][c] = curr + 1;
                    queue.offer(new int[]{r - 1, c});
                }
            }

            if (r + 1 < row) {
                if (matrix[r + 1][c] == notVisited) {
                    matrix[r + 1][c] = curr + 1;
                    queue.offer(new int[]{r + 1, c});
                }
            }

            if (c - 1 >= 0) {
                if (matrix[r][c - 1] == notVisited) {
                    matrix[r][c - 1] = curr + 1;
                    queue.offer(new int[]{r, c - 1});
                }
            }

            if (c + 1 < col) {
                if (matrix[r][c + 1] == notVisited) {
                    matrix[r][c + 1] = curr + 1;
                    queue.offer(new int[]{r, c + 1});
                }
            }
        }

        return matrix;


    }


}
