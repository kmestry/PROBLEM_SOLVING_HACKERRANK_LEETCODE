package com.geeksforgeeks.searching;

public class LeftIndex {


    static int leftIndex(int N, int[] arr, int X) {

        // Your code here
        int low = 0;
        int high = arr.length - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            //.out.println("mid " + mid);
            if (arr[mid] == X && mid == 0 || ((mid > 0) && (arr[mid] == X) && (arr[mid] != arr[mid - 1]))) {
                return mid;
            } else if (X > arr[mid]) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return -1;


    }
}

