package com.leetcode;

import java.util.TreeMap;

public class SlidingWindowMaximumNovemberChallenge {

    public static void main(String[] args) {


        // new SlidingWindowMaximumNovemberChallenge().maxSlidingWindow(new int[]{1, 3, 1, 2, 0, 5}, 3);
        //[9,10,9,-7,-4,-8,2,-6]
        //5
        new SlidingWindowMaximumNovemberChallenge().maxSlidingWindow(new int[]{9, 10, 9, -7, -4, -8, 2, -6}, 5);
    }

    public int[] maxSlidingWindow(int[] nums, int k) {
        int[] result = new int[nums.length - k + 1];
        TreeMap<Integer, Integer> freqMap = new TreeMap<>();

        int left = 0;
        int right = k - 1;
        int index = 0;
        for (int i = left; i <= right; i++) {
            freqMap.put(nums[i], freqMap.getOrDefault(nums[i], 0) + 1);
        }
        while (right < nums.length) {
            result[index] = freqMap.lastEntry().getKey();
            index++;

            Integer value = freqMap.get(nums[left]);

            if (value > 1) {
                freqMap.put(nums[left], freqMap.get(nums[left]) - 1);
            } else if (value == 1) {
                freqMap.remove(nums[left]);
            }
            right++;
            if (right < nums.length) {
                freqMap.put(nums[right], freqMap.getOrDefault(nums[right], 0) + 1);
            }
            left++;
        }

        return result;
    }
}
