package com.geeksforgeeks.searching;

public class SearchInRotatedSortedArray {

    public static void main(String[] args) {
        SearchInRotatedSortedArray searchInRotatedSortedArray = new SearchInRotatedSortedArray();
        //int result = searchInRotatedSortedArray.modifiedBinarySearch(new int[]{10, 20, 40, 60, 5, 8}, 6);
        int result = searchInRotatedSortedArray.modifiedBinarySearch(new int[]{3, 1}, 1);
        System.out.println("result = " + result);
    }
    //10 20 40 60 5 8
    // 6 target

    private int modifiedBinarySearch(int[] arr, int target) {

        int low = 0;
        int high = arr.length - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (arr[mid] == target) {
                return mid;
            }

            if (arr[low] <= arr[mid]) {
                //this means left half is sorted
                if (target >= arr[low] && target < arr[mid]) {
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            } else {
                if (target <= arr[high] && target > arr[mid]) {
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }
        }
        return -1;
    }
}
