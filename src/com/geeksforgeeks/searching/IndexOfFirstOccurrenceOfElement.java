package com.geeksforgeeks.searching;

public class IndexOfFirstOccurrenceOfElement {
    public static void main(String[] args) {

        IndexOfFirstOccurrenceOfElement indexOfFirstOccurrenceOfElement = new IndexOfFirstOccurrenceOfElement();
        int result = indexOfFirstOccurrenceOfElement.indexOfFirstOccurrence(new int[]{5, 10, 10, 15, 20, 20, 20}, 20);
        // int result = indexOfFirstOccurrenceOfElement.indexOfFirstOccurrence(new int[]{}, 20);
        //int result = indexOfFirstOccurrenceOfElement.indexOfFirstOccurrence(new int[]{5, 7, 7, 8, 8, 10}, 5);

//        [5,7,7,8,8,10]
//        8
//                [5,7,7,8,8,10]
//        6
//                []
//        0

        System.out.println("result = " + result);
    }

    // 1 10 10 20 20 40 , 20
    private int indexOfFirstOccurrence(int[] arr, int element) {

        int low = 0;
        int high = arr.length - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (arr[mid] == element) {
                if (mid == 0 || arr[mid] != arr[mid - 1]) {
                    return mid;
                } else {
                    high = mid - 1;
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
