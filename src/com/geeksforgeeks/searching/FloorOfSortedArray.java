package com.geeksforgeeks.searching;

public class FloorOfSortedArray {

    static int findFloor(long[] arr, int n, long x) {
        int low = 0;
        int high = n - 1;

        int index = -1;
        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (arr[mid] == x) {
                return mid;
            } else if (arr[mid] > x) {
                high = mid - 1;

            } else {
                index = mid;
                low = mid + 1;
            }
        }

        return index;
    }
}
