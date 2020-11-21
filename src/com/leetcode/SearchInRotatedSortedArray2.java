package com.leetcode;

public class SearchInRotatedSortedArray2 {

    public boolean search(int[] nums, int target) {

        if (nums.length == 0) return false;
        int pivotIndex = findPivotIndex(nums);


        if (pivotIndex == -1) {
            return binarySearch(nums, target);
        }

        int[] leftOfPivot = new int[pivotIndex];
        int[] rightOfPivot = new int[nums.length - pivotIndex];

        if (pivotIndex >= 0) System.arraycopy(nums, 0, leftOfPivot, 0, pivotIndex);

        int index = 0;
        for (int i = pivotIndex; i < nums.length; i++) {
            rightOfPivot[index] = nums[i];
            index++;
        }

        boolean firstHalf = binarySearch(leftOfPivot, target);

        if (firstHalf) {
            return true;
        } else {
            return binarySearch(rightOfPivot, target);
        }


    }


    private boolean binarySearch(int[] array, int target) {

        int left = 0;
        int right = array.length - 1;

        while (left <= right) {
            int mid = right - (right - left) / 2;

            if (array[mid] == target) {
                return true;
            } else if (target > array[mid]) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }

        }

        return false;
    }

    private int findPivotIndex(int[] nums) {

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] < nums[i - 1]) {
                return i;
            }
        }

        return -1;

    }
}
