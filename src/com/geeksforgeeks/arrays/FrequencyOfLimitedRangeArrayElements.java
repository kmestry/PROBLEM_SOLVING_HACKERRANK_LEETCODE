package com.geeksforgeeks.arrays;

public class FrequencyOfLimitedRangeArrayElements {

    public static void main(String[] args) {

        FrequencyOfLimitedRangeArrayElements arrayInsertAtIndex = new FrequencyOfLimitedRangeArrayElements();
        frequencyCountOptimized(new int[]{2, 3, 2, 3, 5}, 5);
    }

    public static void frequencycount(int[] arr, int n) {
        // code here
        int[] frequency = new int[n + 1];

        for (int i = 0; i < n; i++) {
            frequency[arr[i]]++;
        }

        int index = 0;
        for (int i = 1; i < frequency.length; i++) {
            arr[index] = frequency[i];
            index++;
        }
    }

    public static void frequencyCountOptimized(int[] arr, int n) {

        for (int i = 0; i < arr.length; i++) {
            arr[i] = arr[i] - 1;
        }

        for (int i = 0; i < arr.length; i++) {
            arr[arr[i] % n] = arr[arr[i] % n] + n;
        }

        for (int i = 0; i < n; i++) {
            arr[i] = arr[i] / n;
        }


    }
}
