package com.leetcode;

import java.util.LinkedList;
import java.util.Queue;

public class JumpGame3 {

    public static void main(String[] args) {
        boolean result = new JumpGame3().canReach(new int[]{58, 48, 64, 36, 19, 19, 67, 13, 32, 2, 59, 50, 29, 68, 50, 0, 69, 31, 54, 20, 22, 43, 30, 9, 68, 71, 20, 22, 48, 74, 2, 65, 27, 54, 30, 5, 66, 24, 64, 68, 9, 31, 50, 59, 15, 72, 6, 49, 11, 71, 12, 61, 5, 66, 30, 1, 2, 39, 59, 35, 53, 21, 76, 17, 71, 40, 68, 57, 64, 53, 70, 21, 50, 49, 25, 63, 35},
                46);

        System.out.println("result = " + result);
    }

    public boolean canReach(int[] arr, int start) {
        Queue<Integer> indexQueue = new LinkedList<>();

        boolean[] visited = new boolean[arr.length];
        int startRight = start + arr[start];
        if (startRight < arr.length) {
            indexQueue.offer(startRight);
        }
        int startLeft = start - arr[start];
        if (startLeft >= 0) {
            indexQueue.offer(startLeft);
        }

        while (!indexQueue.isEmpty()) {
            //   System.out.println(indexQueue.size());
            int index = indexQueue.poll();
            if (arr[index] == 0) {
                return true;
            }
            if (index != start && !visited[index]) {
                int right = index + arr[index];
                if (right < arr.length) {
                    indexQueue.offer(right);
                }
                int left = index - arr[index];
                if (left >= 0) {
                    indexQueue.offer(left);
                }
                visited[index] = true;
            }

        }
        return false;
    }
}
