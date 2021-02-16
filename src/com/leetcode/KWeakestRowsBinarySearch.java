package com.leetcode;

import java.util.PriorityQueue;

public class KWeakestRowsBinarySearch {
    public static void main(String[] args) {
        new KWeakestRowsBinarySearch().kWeakestRows(new int[][]{
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

            int ones = countOnes(0, mat[i].length, mat, i);
            priorityQueue.offer(new int[]{i, ones});

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

    private int countOnes(int low, int high, int[][] mat, int row) {
        int l = low;
        int h = high;

        while (l < h) {
            int mid = l + (h - l) / 2;
            if (mat[row][mid] == 1) {
                l = mid + 1;
            } else {
                h = mid;
            }
        }
        return l;
    }
}
