package com.geeksforgeeks.arrays;

import java.util.ArrayList;
import java.util.Arrays;

public class ReverseArrayInGroup {

    public static void main(String[] args) {

        ReverseArrayInGroup reverseArrayInGroup = new ReverseArrayInGroup();
        reverseArrayInGroup.reverseInGroups(
                new ArrayList<>(Arrays.asList(36, 93, 64, 48, 96, 55, 70, 0, 82, 30, 16, 22, 38, 53, 19, 50, 91, 43, 70,
                        88, 10, 57, 14, 94, 13, 36, 59, 32, 54, 58, 18, 82, 67)), 33, 13);
    }

    void reverseInGroups(ArrayList<Integer> arr, int n, int k) {
        // code here

        int start = 0;
        int end = k;

        if (end > n) {
            reverse(arr, 0, n);
            return;
        }

        while (end < n) {

            reverse(arr, start, end);

            start = end;
            end += k;

            if (end > n) {
                end = n;
                /* left over subarray where we don't have k elements */
                reverse(arr, start, end);
                return;
            }
        }
    }


    private void reverse(ArrayList<Integer> arr, int start, int end) {

        int low = start;
        int high = end - 1;

        while (low < high) {

            int temp = arr.get(low);
            arr.set(low, arr.get(high));
            arr.set(high, temp);


            low++;
            high--;
        }

    }
}
