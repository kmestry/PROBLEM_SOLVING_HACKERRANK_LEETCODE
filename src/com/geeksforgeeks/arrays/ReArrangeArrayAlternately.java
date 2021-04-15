package com.geeksforgeeks.arrays;

public class ReArrangeArrayAlternately {
    public static void rearrange(int[] arr, int n) {

        // Your code here
        int[] copyArr = new int[n];

        int low = 0;
        int high = n - 1;
        int i = 0;

        while (low <= high) {
            copyArr[i] = arr[high];
            i++;
            if (i >= 0 && i < n) copyArr[i] = arr[low];
            high--;
            low++;
            i++;
        }

        for (int j = 0; j < n; j++) {
            arr[j] = copyArr[j];
        }
    }
}
