package com.leetcode_march_22;

import java.util.PriorityQueue;

public class KthLargestElementInArray {

    public static void main(String[] args) {
        KthLargestElementInArray kthLargestElementInArray = new KthLargestElementInArray();
        kthLargestElementInArray.findKthLargest(new int[]{3, 2, 3, 1, 2, 4, 5, 5, 6}, 2);
    }

    public int findKthLargest(int[] nums, int k) {

        PriorityQueue<Integer> pq = new PriorityQueue<>((o1, o2) -> o2 - o1);

        for (int num : nums) {
            pq.add(num);
        }

        while (!pq.isEmpty() && k > 1) {
            pq.poll();
            k--;
        }

        return pq.poll();

    }
}
