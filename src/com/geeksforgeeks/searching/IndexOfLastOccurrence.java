package com.geeksforgeeks.searching;

public class IndexOfLastOccurrence {
    public static void main(String[] args) {

        IndexOfLastOccurrence indexOfLastOccurrence = new IndexOfLastOccurrence();
        int result = indexOfLastOccurrence.indexOfLastOccurrence(new int[]{10, 15, 20, 20, 40, 40}, 20);
        //int result = indexOfLastOccurrence.indexOfLastOccurrence(new int[]{}, 10);
        System.out.println("result = " + result);
    }

    //10 15 20 20 40 40 , ele = 40
    private int indexOfLastOccurrence(int[] arr, int element) {

        int low = 0;
        int high = arr.length - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (arr[mid] == element) {
                if (mid == arr.length - 1 || arr[mid] != arr[mid + 1]) {
                    return mid;
                } else {
                    low = mid + 1;
                }
            } else if (element > arr[mid]) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return -1;

    }
}
