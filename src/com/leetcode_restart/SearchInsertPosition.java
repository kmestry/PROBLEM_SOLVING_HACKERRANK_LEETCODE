package com.leetcode_restart;

public class SearchInsertPosition {

    public int searchInsert(int[] nums, int target) {

        if (target < nums[0]) return 0;
        if (target > nums[nums.length - 1]) return nums.length;

        int l = 0;
        int r = nums.length - 1;

        while (l <= r) {
            int mid = l + (r - l) / 2;

            if (target == nums[mid] || target < nums[mid] && mid > 0 && target > nums[mid - 1]) {
                return mid;
            }
            if (target > nums[mid]) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }

        return -1;
    }
}
