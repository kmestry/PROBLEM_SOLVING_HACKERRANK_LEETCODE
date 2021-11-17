package com.leetcode;

import java.util.Comparator;
import java.util.PriorityQueue;

public class KthLargestElement {

    public static void main(String[] args) {
        // new KthLargestElement().findKthLargest(new int[]{3, 2, 3, 1, 2, 4, 5, 5, 6}, 4);
        int result = new KthLargestElement().findKthLargest(new int[]{1, 2, 3}, 3);
        System.out.println("result = " + result);
    }

    public int findKthLargest(int[] nums, int k) {

        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
        for (int num : nums) {
            priorityQueue.offer(num);

            if (priorityQueue.size() > k) {
                priorityQueue.poll();
            }
        }
        return priorityQueue.poll();
    }

    public int findKthLargestApproach2(int[] nums, int k) {
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(Comparator.reverseOrder());
        for (int num : nums) {
            priorityQueue.offer(num);
        }
        int val = 0;
        while (!priorityQueue.isEmpty()) {
            val = priorityQueue.poll();
            k--;

            if (k == 0) {
                return val;
            }
        }

        return val;
    }
}
