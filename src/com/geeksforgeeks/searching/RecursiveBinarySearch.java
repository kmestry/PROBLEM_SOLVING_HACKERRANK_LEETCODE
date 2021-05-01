package com.geeksforgeeks.searching;

public class RecursiveBinarySearch {

    public static void main(String[] args) {
        RecursiveBinarySearch recursiveBinarySearch = new RecursiveBinarySearch();
        int index = recursiveBinarySearch.searchElement(new int[]{1, 2, 3, 4, 5}, 1, 0, 4);
        //int index = binarySearchIterative.searchElement(new int[]{1, 1}, 1);
        System.out.println("index = " + index);
    }

    // 1 2 3 4 5 , 3
    private int searchElement(int[] arr, int element, int low, int high) {

        if (low > high) {
            return -1;
        }
        int mid = low + (high - low) / 2;
        if (arr[mid] == element) {
            return 1;
        } else if (element > arr[mid]) {
            return searchElement(arr, element, mid + 1, high);
        } else {
            return searchElement(arr, element, low, mid - 1);
        }

    }
}
