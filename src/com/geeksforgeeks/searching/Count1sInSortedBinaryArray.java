package com.geeksforgeeks.searching;

public class Count1sInSortedBinaryArray {
    public static void main(String[] args) {

        Count1sInSortedBinaryArray count1sInSortedBinaryArray = new Count1sInSortedBinaryArray();
        int[] arr = new int[]{0, 0, 1, 1};
        int result = count1sInSortedBinaryArray.firstOccurrence(arr, 1);

        if (result != -1)
            System.out.println("count of one is : " + (arr.length - result));
        else
            System.out.println("count of one is zero!");

    }

    private int firstOccurrence(int[] arr, int target) {
        //find first occurrence of 1.

        int low = 0;
        int high = arr.length - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (arr[mid] == target) {
                if (mid == 0 || arr[mid] != arr[mid - 1]) {
                    return mid;
                } else {
                    high = mid - 1;
                }
            } else if (target > arr[mid]) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return -1;

    }
}
