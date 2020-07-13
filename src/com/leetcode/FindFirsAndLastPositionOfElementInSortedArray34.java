package com.leetcode;

import java.util.Arrays;

public class FindFirsAndLastPositionOfElementInSortedArray34 {

    public static int[] searchRange(int[] nums, int target) {

        if (nums.length == 0)
            return new int[]{-1, -1};

        int firstPositionOfTarget = findFirstPositionOfTarget(nums, target);
        if (firstPositionOfTarget >= 0) {
            int lastPositionOfTarget = findLastPositionOfTargetBinarySearch(Arrays.copyOfRange(nums, firstPositionOfTarget, nums.length), target);
            return new int[]{firstPositionOfTarget, firstPositionOfTarget + lastPositionOfTarget};
        } else {
            return new int[]{-1, -1};
        }


    }

    public static void main(String[] args) {
        //searchRange(new int[]{1, 1, 2, 6, 6, 6, 6, 6, 6, 6,10}, 6);
        // searchRange(new int[]{5, 7, 7, 8, 8, 10}, 8);
        //searchRange(new int[]{1,2,3}, 1);
        // findLastPositionOfTarget(new int[]{6, 6, 6, 6, 6, 6, 9, 10}, 6);
        searchRange(new int[]{2, 2}, 2);
    }

    public static int findFirstPositionOfTarget(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left + 1 < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] < target) {
                left = mid;
            } else {
                right = mid;
            }
        }
        if (nums[left] == target) return left;
        if (nums[right] == target) return right;
        return -1;
    }

    public static int findLastPositionOfTarget(int[] nums, int target) {

        for (int i = 0; i < nums.length; i++) {
            if (i < nums.length - 1 && nums[i] != nums[i + 1]) {
                return i;
            }
        }
        if (nums[nums.length - 1] == target) return nums.length - 1;
        return 0;
    }

    public static int findLastPositionOfTargetBinarySearch(int[] nums, int target) {

        if (nums.length == 1 && nums[0] == target)
            return 0;

        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target && nums[mid] == nums[mid + 1] && mid + 1 == nums.length - 1)
                return mid + 1;
            if (nums[mid] == target && nums[mid] != nums[mid + 1]) {
                return mid;
            } else if (target < nums[mid]) {
                right = mid - 1;
            } else if (nums[mid] == target) {
                left = mid + 1;
            }
        }
        if (nums[nums.length - 1] == target) return nums.length - 1;
        return 0;
    }

}
