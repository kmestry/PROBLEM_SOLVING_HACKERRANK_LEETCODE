package com.geeksforgeeks.arrays;

public class MaximumOccurredIntegerArrayApproach {
    public static void main(String[] args) {
        MaximumOccurredIntegerArrayApproach.maxOccurred(new int[]{1, 4, 3, 1}, new int[]{15, 8, 5, 4}, 4, 0);
    }

    public static int maxOccurred(int[] L, int[] R, int n, int maxx) {
        int[] arr = new int[1000000];

        for (int i = 0; i < L.length; i++) {

            for (int j = L[i]; j <= R[i]; j++) {

                arr[j]++;
            }
        }

        int maxOccurred = 0;
        int element = 0;
        for (int i = 0; i < arr.length; i++) {

            if (arr[i] > maxOccurred) {
                element = i;
                maxOccurred = arr[i];
            }
        }
        return element;
    }
}
