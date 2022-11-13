package com.datastructure_2_studyplan_leetcode.day20;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class KthLargestElementInArray {

    public static void main(String[] args) {
        KthLargestElementInArray largestElementInArray = new KthLargestElementInArray();
        largestElementInArray.findKthLargestPriorityQueue(new int[]{3, 2, 3, 1, 2, 4, 5, 5, 6}, 4);
    }

    public int findKthLargest(int[] nums, int k) {

        List<Integer> list = new ArrayList<>();
        for (int num : nums) {
            Integer integer = num;
            list.add(integer);
        }
        list.sort((o1, o2) -> o2 - o1);

        return list.get(k - 1);
    }


    public int findKthLargestPriorityQueue(int[] nums, int k) {

        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();

        for (int num : nums) {
            priorityQueue.offer(num);
            if(priorityQueue.size() > k)
                priorityQueue.poll();
        }


        return priorityQueue.peek();
    }

}
