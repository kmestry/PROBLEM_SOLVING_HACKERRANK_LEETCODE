package com.blind_list_75.practise;

public class SearchInRotatedSortedArray {

    public static void main(String[] args) {
        SearchInRotatedSortedArray searchInRotatedSortedArray = new SearchInRotatedSortedArray();
        //searchInRotatedSortedArray.search(new int[]{4, 5, 6, 7, 0, 1, 2}, 0);
        //searchInRotatedSortedArray.search(new int[]{1, 3}, 3);
        searchInRotatedSortedArray.search(new int[]{3, 1}, 1);
    }

    public int search(int[] nums, int target) {

        int l = 0;
        int r = nums.length - 1;

        while (l < r) {
            int mid = l + (r - l) / 2;
            //right part is sorted
            if (nums[mid] == target) return mid;
            if (nums[mid] < nums[r]) {
                if (target >= nums[mid] && target <= nums[r]) {
                    return binarySearch(nums, target, mid, r);
                } else {
                    r = mid - 1;
                }
            } else if (nums[mid] >= nums[l]) {
                if (target >= nums[l] && target <= nums[mid]) {
                    return binarySearch(nums, target, l, mid);
                } else {
                    l = mid + 1;
                }
            }
        }
        return l == r && nums[l] == target ? l : -1;
    }
    //  0  1  2  3  4  5  6  7
    // {7, 8, 1, 2, 3, 4, 5, 6}, 1);


    private int binarySearch(int[] nums, int target, int l, int r) {

        while (l <= r) {
            int mid = l + (r - l) / 2;

            if (nums[mid] == target) {
                return mid;
            } else if (target > nums[mid]) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }

        return -1;
    }
}
