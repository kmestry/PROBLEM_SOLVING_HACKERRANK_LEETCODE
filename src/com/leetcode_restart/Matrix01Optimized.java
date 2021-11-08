package com.leetcode_restart;

import java.util.LinkedList;
import java.util.Queue;

public class Matrix01Optimized {

    public static void main(String[] args) {
        new Matrix01Optimized().updateMatrix(new int[][]{
                {0, 0, 0},
                {0, 1, 0},
                {1, 1, 1}});
    }

    public int[][] updateMatrix(int[][] mat) {

        int[][] dirs = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[0].length; j++) {

                if (mat[i][j] == 0) {
                    queue.offer(new int[]{i, j});
                } else {
                    mat[i][j] = -1;
                }
            }
        }

        int length = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();
            length++;
            for (int i = 0; i < size; i++) {
                int[] arr = queue.poll();
                for (int[] dir : dirs) {
                    int ii = dir[0] + arr[0];
                    int jj = dir[1] + arr[1];

                    if (ii >= 0 && ii < mat.length && jj >= 0 && jj < mat[0].length) {
                        if (mat[ii][jj] == -1) {
                            mat[ii][jj] = length;
                            queue.offer(new int[]{ii, jj});
                        }
                    }
                }
            }
        }
        return mat;
    }
}
