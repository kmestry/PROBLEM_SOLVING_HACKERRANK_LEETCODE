package com.geeksforgeeks.searching.practise;

public class PeakElement {

    public static void main(String[] args) {

        PeakElement peakElement = new PeakElement();
        peakElement.peakElement(new int[]{17, 19, 9, 5, 3, 6, 17, 7, 18, 16, 18, 11, 3, 15, 2}, 15);
    }

    private int peakElement(int[] arr, int n) {

        int low = 0;
        int high = n - 1;

        if (arr[0] >= arr[1]) {
            return 0;
        }
        if (arr[n - 1] >= arr[n - 2]) {
            return n - 1;
        }
        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (mid < n && arr[mid] >= arr[mid + 1] && mid >= 0 && arr[mid] >= arr[mid - 1]) {
                return mid;
            } else if (arr[mid + 1] > arr[mid]) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return -1;
    }
}

