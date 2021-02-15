package com.leetcode;

import java.util.ArrayDeque;
import java.util.Deque;

public class MostCompetitiveSubsequence {

    public static void main(String[] args) {
        new MostCompetitiveSubsequence().mostCompetitive(new int[]{2, 4, 3, 3, 5, 4, 9, 6}, 4);
    }
//    [2,4,3,3,5,4,9,6]
//            4

    public int[] mostCompetitive(int[] nums, int k) {

        int attempts = nums.length - k;

        Deque<Integer> integerDeque = new ArrayDeque<>();
        for (int num : nums) {
            while (!integerDeque.isEmpty() && integerDeque.peekLast() > num && attempts > 0) {
                integerDeque.pollLast();
                attempts--;
            }
            integerDeque.offer(num);
        }
        while (integerDeque.size() > k) {
            integerDeque.pollLast();
        }

        int[] result = new int[k];
        int index = 0;
        while (!integerDeque.isEmpty()) {
            result[index] = integerDeque.pollFirst();
            index++;
        }

        return result;

    }
}
