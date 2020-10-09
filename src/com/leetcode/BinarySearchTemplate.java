package com.leetcode;

class SearchInsertPosition {

    //intuition , complex but accepted
    public int searchInsert(int[] nums, int target) {

        int left = 0;
        int right = nums.length - 1;

        boolean isNotFound = false;
        while (left <= right) {

            int mid = left + (right - left) / 2;
            if (left == right && right == mid && nums[mid] != target) {
                isNotFound = true;
                break;
            }

            if (target > nums[mid]) {
                left = mid + 1;
            } else if (target < nums[mid]) {
                right = mid - 1;
            } else {
                return mid;
            }
        }

        if (isNotFound && left - 1 > -1 && target < nums[left] && target > nums[left - 1]) return left;
        if (isNotFound && target > nums[left]) return left + 1;
        if (isNotFound && target < nums[left]) return left - 1 == -1 ? 0 : left - 1;

        if (right < 0) return 0;
        if (left > nums.length - 1) return nums.length;
        if ((left < (nums.length - 1)) && (target > nums[right]) && (target < nums[left])) {

            return left;
        }


        return -1;
    }
}
