package com.leetcode_restart;

import java.util.LinkedList;
import java.util.Queue;

public class RottenOranges {

    public static void main(String[] args) {
        int result = new RottenOranges().orangesRotting(new int[][]{{
                2, 1, 1},
                {1, 1, 0},
                {0, 1, 1}});
        System.out.println("result = " + result);
    }

    public int orangesRotting(int[][] grid) {

        Queue<int[]> queue = new LinkedList<>();

        int rows = grid.length;
        int cols = grid[0].length;

        int fresh = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                int val = grid[i][j];

                if (val == 1) {
                    fresh++;
                } else if (val == 2) {
                    queue.add(new int[]{i, j});
                }
            }
        }

        if (fresh == 0) return 0;
        int[][] dirs = new int[][]{{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
        int count = 0;
        while (!queue.isEmpty() && fresh > 0) {
            count++;
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                int[] rotten = queue.poll();

                for (int[] dir : dirs) {
                    int x = rotten[0] + dir[0];
                    int y = rotten[1] + dir[1];

                    if (x < 0 || y < 0 || x >= rows || y >= cols || grid[x][y] == 0 || grid[x][y] == 2) continue;

                    grid[x][y] = 2;

                    queue.offer(new int[]{x, y});
                    fresh--;
                }

            }
        }

        return fresh == 0 ? count  : -1;
    }
}
