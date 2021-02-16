package com.leetcode;

import java.util.PriorityQueue;

public class KWeakestRowPriorityQueue {

    public static void main(String[] args) {
        new KWeakestRowPriorityQueue().kWeakestRows(new int[][]{
                {1, 1, 0, 0, 0},
                {1, 1, 1, 1, 0},
                {1, 0, 0, 0, 0},
                {1, 1, 0, 0, 0},
                {1, 1, 1, 1, 1}
        }, 3);
    }

    public int[] kWeakestRows(int[][] mat, int k) {

        PriorityQueue<int[]> priorityQueue = new PriorityQueue<>((o1, o2) ->
                o1[1] == o2[1] ? o2[0] - o1[0] : o2[1] - o1[1]);

        for (int i = 0; i < mat.length; i++) {
            int count = 0;
            for (int j = 0; j < mat[0].length; j++) {
                int val = mat[i][j];
                if (val == 1) {
                    count++;
                } else {
                    break;
                }
            }
            priorityQueue.offer(new int[]{i, count});
            if (priorityQueue.size() > k) {
                priorityQueue.poll();
            }
        }
        int[] result = new int[k];
        int index = k - 1;
        while (!priorityQueue.isEmpty()) {

            result[index--] = priorityQueue.poll()[0];
        }

        return result;
    }
}
