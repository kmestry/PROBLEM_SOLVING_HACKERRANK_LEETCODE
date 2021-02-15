package com.leetcode;

import java.util.LinkedList;
import java.util.Queue;

public class ShortedPathInBinaryMatrix {

    int[][] dir = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}, {1, 1}, {-1, -1}, {1, -1}, {-1, 1}};

    public int shortestPathBinaryMatrix(int[][] grid) {
        Queue<PairRC> queue = new LinkedList<>();
        int maxRow = grid.length;
        int maxCol = grid[0].length;
        if (grid[0][0] != 0) return -1;
        queue.offer(new PairRC(0, 0));

        int length = 1;
        boolean[][] visited = new boolean[maxRow][maxCol];
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                PairRC node = queue.poll();

                assert node != null;
                if (grid[node.row][node.col] == 0) {
                    if (node.row == maxRow - 1 && node.col == maxCol - 1) {
                        return length;
                    }
                    for (int[] arr : dir) {
                        int newR = node.row + arr[0];
                        int newC = node.col + arr[1];
                        if (newR >= 0 && newR < maxRow
                                && newC >= 0 && newC < maxCol
                                && !visited[newR][newC] && grid[newR][newC] == 0) {

                            queue.offer(new PairRC(newR, newC));
                            visited[newR][newC] = true;

                        }
                    }

                }
            }
            length++;
        }
        return -1;

    }
}


class PairRC {
    int row;
    int col;

    PairRC(int row, int col) {
        this.row = row;
        this.col = col;
    }
}