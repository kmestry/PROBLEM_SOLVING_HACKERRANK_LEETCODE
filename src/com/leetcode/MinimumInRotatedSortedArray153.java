package com.leetcode;

public class MinimumInRotatedSortedArray153 {
    public static void main(String[] args) {
        int result = findMin(new int[]{2, 3, 4, 5, 6, 7, 8});
        System.out.println("result = " + result);

    }

    public static int findMin(int[] nums) {

        int left = 0;
        int right = nums.length - 1;

        if (nums[left] < nums[right])
            return nums[left];

        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] > nums[right]) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return nums[left];


    }
}
