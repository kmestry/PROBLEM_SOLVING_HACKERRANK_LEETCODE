package com.leetcode.twentythree;

import java.util.PriorityQueue;

public class LastStoneWeight {

    public static void main(String[] args) {
        LastStoneWeight lastStoneWeight = new LastStoneWeight();
        lastStoneWeight.lastStoneWeight(new int[]{2, 7, 4, 1, 8, 1});
    }

    public int lastStoneWeight(int[] stones) {

        PriorityQueue<Integer> pq = new PriorityQueue<>((o1, o2) -> o2 - o1);

        for (int i : stones) {
            pq.offer(i);
        }

        while (pq.size() >= 2) {
            int first = pq.poll();
            int sec = pq.poll();

            if (first != sec) {
                pq.offer(first - sec);
            }
        }

        return pq.isEmpty() ? 0 : pq.poll();


    }
}
