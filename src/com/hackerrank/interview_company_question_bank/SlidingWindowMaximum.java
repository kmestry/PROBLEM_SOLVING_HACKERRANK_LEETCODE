package com.hackerrank.interview_company_question_bank;


import java.util.Comparator;
import java.util.PriorityQueue;

/*Input: nums = [1,3,-1,-3,5,3,6,7], k = 3
        Output: [3,3,5,5,6,7]*/
public class SlidingWindowMaximum {

    public static void main(String[] args) {
        SlidingWindowMaximum slidingWindowMaximum = new SlidingWindowMaximum();
        slidingWindowMaximum.maxSlidingWindow(new int[]{1, 3, -1, -3, 5, 3, 6, 7}, 3);
    }

    public int[] maxSlidingWindow(int[] nums, int k) {

        int[] result = new int[nums.length - k + 1];
        int index = 0;
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(Comparator.reverseOrder());

        for (int i = 0; i < k; i++) {
            priorityQueue.add(nums[i]);
        }
        result[index] = priorityQueue.peek();
        index++;
        int pointer1 = 0;
        int pointer2 = k;
        while (pointer2 < nums.length) {
            priorityQueue.remove(nums[pointer1]);
            priorityQueue.add(nums[pointer2]);
            result[index] = priorityQueue.peek();
            //list.add(priorityQueue.peek());
            pointer1++;
            pointer2++;
            index++;
        }

        return result;
    }
}
