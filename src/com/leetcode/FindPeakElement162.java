package com.leetcode;

public class FindPeakElement162 {

    public static void main(String[] args) {
        findPeakElement(new int[]{1, 2});
    }

    public static int findPeakElement(int[] nums) {

        int left = 0;
        int right = nums.length - 1;
        int indexElement = 0;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] > nums[mid + 1]) {
                indexElement = mid;
                break;
            } else {
                left = mid + 1;
            }

        }
        for (int i = indexElement; i < nums.length; i++) {
            if (i < nums.length - 1 && nums[i] > nums[i + 1]) {
                continue;
            } else {
                break;
            }

        }
        return indexElement;
    }
}
