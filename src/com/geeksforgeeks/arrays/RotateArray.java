package com.geeksforgeeks.arrays;

public class RotateArray {

    static void rotateArr(int[] arr, int d, int n) {
        // add your code here
        int[] temp = new int[d];

        for (int i = 0; i < d; i++) {
            temp[i] = arr[i];
        }

        for (int i = d; i < n; i++) {
            arr[i - d] = arr[i];
        }

        int index = 0;
        for (int i = n - d; i < n; i++) {
            arr[i] = temp[index];
            index++;
        }
    }
}
