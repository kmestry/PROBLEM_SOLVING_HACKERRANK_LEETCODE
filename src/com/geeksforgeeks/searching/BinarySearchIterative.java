package com.geeksforgeeks.searching;

public class BinarySearchIterative {

    public static void main(String[] args) {

        BinarySearchIterative binarySearchIterative = new BinarySearchIterative();
        // int index = binarySearchIterative.searchElement(new int[]{1, 2, 3, 4, 5}, 21);
        int index = binarySearchIterative.searchElement(new int[]{1, 1}, 1);
        System.out.println("index = " + index);
    }


    // 1 2 3 4 5
    private int searchElement(int[] arr, int element) {
        int low = 0;
        int high = arr.length - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (arr[mid] == element) {
                return mid;
            } else if (element > arr[mid]) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }

        }
        return -1;

    }
}
