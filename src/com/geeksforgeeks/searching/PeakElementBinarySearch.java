package com.geeksforgeeks.searching;

public class PeakElementBinarySearch {

    //unique problem as we are using binary search even when array is not sorted
    public static void main(String[] args) {

        PeakElementBinarySearch peakElementBinarySearch = new PeakElementBinarySearch();
        peakElementBinarySearch.findPeakElementIndex(new int[]{50, 60, 40, 30, 20, 50, 10});
    }

    private int findPeakElementIndex(int[] arr) {
        //every array has 1 or more peak elements.

        if (arr.length == 1) {
            return 0;
        }

        //check if corner elements are peak. if true return early.
        if (arr[0] >= arr[1]) {
            return 0;
        }
        if (arr[arr.length - 1] >= arr[arr.length - 2]) {
            return arr.length - 1;
        }

        int low = 0;
        int high = arr.length - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if ((mid == 0 || arr[mid] >= arr[mid - 1])
                    && (mid == arr.length - 1 || arr[mid] >= arr[mid + 1])) {
                return mid;
            }
            if (mid > 0 && arr[mid - 1] > arr[mid]) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }

        }
        return -1;
    }
}
