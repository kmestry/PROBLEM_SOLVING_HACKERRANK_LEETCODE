package com.leetcode;

public class FindMinimumInRotatedSortedArray2 {

    static int recursionResult = 0;
    static boolean isVisited = false;

    public static void main(String[] args) {

        findMinBinarySearch(new int[]{1, 1, 1, 0, 1, 1, 1, 1, 1, 1, 1, 1

        });
    }

    public static int findMin(int[] nums) {

        boolean isRotated = false;
        int resultOfRotated = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i + 1] < nums[i]) {
                isRotated = true;
                resultOfRotated = nums[i + 1];
                break;
            }
        }
        return isRotated ? resultOfRotated : nums[0];
    }

    public static int findMinBinarySearch(int[] nums) {

        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] > nums[right]) left = mid + 1;
            else if (nums[mid] < nums[left]) right = mid;
            else right--;
        }

        return nums[left];
    }
}
