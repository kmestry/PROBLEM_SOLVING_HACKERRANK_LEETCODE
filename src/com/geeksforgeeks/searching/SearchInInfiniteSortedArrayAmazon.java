package com.geeksforgeeks.searching;

public class SearchInInfiniteSortedArrayAmazon {

    public static void main(String[] args) {

        SearchInInfiniteSortedArrayAmazon searchInInfiniteSortedArrayAmazon = new SearchInInfiniteSortedArrayAmazon();
        int result = searchInInfiniteSortedArrayAmazon.findIndexInInfiniteArray
                (new int[]{1, 10, 15, 20, 40, 60, 80, 100, 200, 300}, 300);
        System.out.println("result = " + result);
    }

    private int findIndexInInfiniteArray(int[] arr, int target) {
        // 0 1  2  3   4  5  6 7    8
        // 1 10 15 20 40 60 80 100 200 300... target 100
        if (arr[0] == target) return 0;

        int rightIndex = 1;
        int leftIndex = 1;
        while (arr[rightIndex] < target) {
            leftIndex = rightIndex;
            rightIndex *= 2;

        }

        return binarySearch(arr, target, leftIndex, rightIndex);
    }

    private int binarySearch(int[] arr, int target, int low, int high) {


        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (arr[mid] == target) {
                return mid;
            } else if (target > arr[mid]) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return -1;
    }
}
