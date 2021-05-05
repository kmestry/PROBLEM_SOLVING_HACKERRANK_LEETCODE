package com.geeksforgeeks.searching;

public class SearchInInfiniteSortedArray {
    public static void main(String[] args) {

    }

    private int findIndex(int[] arr, int target) {
        //assume arr is infinite. u do not know the length of the array.

        int i = 0;

        while (true) {
            if (arr[i] == target) {
                return i;
            }
            if (arr[i] > target) {
                return -1;
            }
            i++;
        }
    }
}
