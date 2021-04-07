package com.geeksforgeeks.arrays;

public class RotateArrayAntiClockWiseReversalAlgorithm {

    //Function to rotate an array by d elements in counter-clockwise direction.
    static void rotateArr(int[] arr, int d, int n) {
        reverse(arr, 0, d);
        reverse(arr, d, n);
        reverse(arr, 0, n);

    }

    private static void reverse(int[] arr, int start, int end) {

        int low = start;
        int high = end - 1;

        while (low < high) {

            int temp = arr[high];

            arr[high] = arr[low];
            arr[low] = temp;

            low++;
            high--;
        }
    }
}
