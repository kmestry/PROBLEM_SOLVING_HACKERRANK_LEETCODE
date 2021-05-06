package com.geeksforgeeks.searching;

import java.util.Arrays;

public class PythagoreanTriplet {

    public static void main(String[] args) {

        PythagoreanTriplet pythagoreanTriplet = new PythagoreanTriplet();
        pythagoreanTriplet.checkTriplet(new int[]{3, 2, 4, 6, 5}, 5);
    }

    boolean checkTriplet(int[] arr, int n) {
        // code here
        // 2 3 4 5 6
        Arrays.sort(arr);
        for (int i = 0; i < arr.length; i++) {
            arr[i] = arr[i] * arr[i];
        }
        for (int i = arr.length - 1; i >= 0; i--) {
            if (findPair(arr, arr[i], 0, i - 1)) {
                return true;
            }
        }
        return false;

    }

    private boolean findPair(int[] arr, int target, int low, int high) {

        while (low < high) {
            int sum = arr[low] + arr[high];

            if (sum == target) {
                return true;
            } else if (sum > target) {
                high--;
            } else {
                low++;
            }
        }

        return false;
    }
}
