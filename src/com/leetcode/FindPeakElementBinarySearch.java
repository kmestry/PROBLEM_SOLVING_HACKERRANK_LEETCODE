package com.leetcode;

public class FindPeakElementBinarySearch {

    public static void main(String[] args) {
        findPeakElement(new int[]{3, 2, 1});
    }

    public static int findPeakElement(int[] nums) {

        if (nums.length == 1)
            return 0;
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (mid > 0 && nums[mid - 1] > nums[mid]) {
                right = mid - 1;
            } else if (mid == nums.length - 1)
                return mid;

            else if (nums[mid] > nums[mid + 1]) {
                return mid;
            } else if (nums[mid + 1] > nums[mid]) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return -1;
    }
}
