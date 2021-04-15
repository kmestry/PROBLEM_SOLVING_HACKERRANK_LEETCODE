package com.geeksforgeeks.arrays;

public class ReArrangeArrayAlternatelyOptimized {
    public static void main(String[] args) {
        ReArrangeArrayAlternatelyOptimized reArrangeArrayAlternatelyOptimized = new ReArrangeArrayAlternatelyOptimized();
        reArrangeArrayAlternatelyOptimized.rearrange(new int[]{1, 2, 3, 4, 5, 6}, 6);
    }

    public void rearrange(int[] arr, int n) {

        //Tricky solution
        int maxElement = arr[n - 1] + 1;
        int minIndex = 0;
        int maxIndex = n - 1;

        for (int i = 0; i < n; i++) {

            if (i % 2 == 0) {
                arr[i] += (arr[maxIndex] % maxElement) * maxElement;
                maxIndex--;
            } else {
                arr[i] += (arr[minIndex] % maxElement) * maxElement;
                minIndex++;
            }
        }

        for (int i = 0; i < n; i++) {
            arr[i] = arr[i] / maxElement;
        }
    }
}
