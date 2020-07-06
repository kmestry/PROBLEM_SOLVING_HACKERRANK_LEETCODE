package com.leetcode;

public class SearchInRotatedArrayOptimized33 {


    /*
    * [7,8,1,2,3,4,5,6]
        2
    * */

    public static void main(String[] args) {
        int result = search(new int[]{7, 8, 1, 2, 3, 4, 5, 6}, 2);
        System.out.println("result = " + result);
    }


    public static int binarySearch(int[] nums, int left, int right, int target) {
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (target < nums[mid]) {
                right = mid - 1;
            } else if (target > nums[mid]) {
                left = mid + 1;
            } else {
                return mid;
            }
        }
        return -1;
    }


    public static int findMinimumElementIndex(int[] nums) {
        int left = 0;
        int right = nums.length - 1;

        if (nums.length == 1) {
            return 0;
        }

        while (left < right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] > nums[right]) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        return left;
    }
    //4,5,6,7,0,1,2

    public static int search(int[] nums, int target) {

        if (nums.length == 0) {
            return -1;
        }

        int minimumElementIndex = findMinimumElementIndex(nums);
        if (minimumElementIndex == 0) {
            int result = binarySearch(nums, 0, nums.length - 1, target);
            return result;
        }
        int result = binarySearch(nums, minimumElementIndex, nums.length - 1, target);

        if (result == -1) {

            int resultLeftSide = binarySearch(nums, 0, minimumElementIndex - 1, target);
            return resultLeftSide;
        }
        return result;


    }
}
