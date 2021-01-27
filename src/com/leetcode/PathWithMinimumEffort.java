package com.leetcode;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class PathWithMinimumEffort {

    private final int[] d = {0, 1, 0, -1, 0};

    public static void main(String[] args) {
        new PathWithMinimumEffort().minimumEffortPath(new int[][]{{1, 2, 2}, {3, 8, 2}, {5, 3, 5}});
    }

    public int minimumEffortPath(int[][] heights) {
        int[] dir = new int[]{0, 1, 0, -1, 0};
        int row = heights.length;
        int col = heights[0].length;

        int[][] efforts = new int[row][col];
        for (int[] effort : efforts) {
            Arrays.fill(effort, Integer.MAX_VALUE);
        }
        efforts[0][0] = 0;
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(o -> o[0]));
        pq.offer(new int[]{0, 0, 0});

        while (!pq.isEmpty()) {
            int[] arr = pq.poll();
            int x = arr[1];
            int y = arr[2];
            int effort = arr[0];
            if (x == row - 1 && y == col - 1) {
                return effort;
            }

            for (int k = 0; k < 4; k++) {
                int newX = x + dir[k];
                int newY = y + dir[k + 1];

                if (newX >= 0 && newY >= 0 && newX < row && newY < col) {
                    int newEffort = Math.max(effort, Math.abs(heights[newX][newY] - heights[x][y]));
                    if (newEffort < efforts[newX][newY]) {
                        efforts[newX][newY] = newEffort;
                        pq.offer(new int[]{newEffort, newX, newY});
                    }
                }
            }
        }

        return 0;
    }
}
