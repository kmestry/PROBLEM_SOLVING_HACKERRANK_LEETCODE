package com.blind_list_75.array;

public class SearchInRotatedSortedArray {

    public int search(int[] nums, int target) {

        if (nums.length == 1) {
            return nums[0] == target ? 0 : -1;
        }
        int pivot = findPivot(nums);
        //System.out.println("== " + pivot);

        if (pivot == -1) {
            return binarySearch(nums, 0, nums.length - 1, target);
        }

        if (pivot != -1 && nums[pivot] == target) {
            return pivot;
        }


        if (target >= nums[0] && target <= nums[pivot - 1]) {
            return binarySearch(nums, 0, pivot - 1, target);
        } else {
            return binarySearch(nums, pivot, nums.length - 1, target);
        }


    }


    private int binarySearch(int[] nums, int low, int high, int target) {

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (nums[mid] == target) {
                return mid;
            } else if (target > nums[mid]) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return -1;
    }

    private int findPivot(int[] nums) {
        int low = 0;
        int high = nums.length - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (mid > 0 && nums[mid] < nums[mid - 1]) {
                return mid;
            } else if (nums[low] <= nums[mid] && nums[mid] >= nums[high]) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return -1;

    }
}
