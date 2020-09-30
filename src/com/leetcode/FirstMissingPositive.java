package com.leetcode;

import java.util.Arrays;

public class FirstMissingPositive {

    public int firstMissingPositive(int[] nums) {

        Arrays.sort(nums);

        int index = 1;

        while (index < Integer.MAX_VALUE) {
            boolean result = search(nums, index);

            if (!result) {
                return index;
            }
            index++;
        }


        return -1;

    }

    private boolean search(int[] nums, int value) {

        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == value) {
                return true;
            } else if (value > nums[mid]) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return false;
    }
}
