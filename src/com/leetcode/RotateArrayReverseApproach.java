package com.leetcode;

public class RotateArrayReverseApproach {

    public void rotate(int[] nums, int k) {

        // -1 -100 3 99
        // 99 3 -100 -1 reverse
        // 3 99  k == 2 reverse first k
        // -1 -100 // reverse  remaining

        if (nums.length < 2) {
            return;
        }
        if (k > nums.length) k = k % nums.length;

        reverse(nums, 0, nums.length - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, nums.length - 1);

    }

    private void reverse(int[] nums, int start, int end) {

        int left = start;
        int right = end;

        while (left < right) {

            int temp1 = nums[left];
            int temp2 = nums[right];

            nums[left] = temp2;
            nums[right] = temp1;

            left++;
            right--;

        }

    }
}
