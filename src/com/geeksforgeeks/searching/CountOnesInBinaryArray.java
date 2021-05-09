package com.geeksforgeeks.searching;

public class CountOnesInBinaryArray {

    public static int countOnes(int[] arr, int N) {

        // Your code here

        int low = 0;
        int high = arr.length - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (mid == arr.length - 1 || (arr[mid] == 1 && mid < arr.length - 1 && arr[mid] != arr[mid + 1])) {
                return mid + 1;
            } else if (arr[mid] == 0) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return 0;

    }
}
