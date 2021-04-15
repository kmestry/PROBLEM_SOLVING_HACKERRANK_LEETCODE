package com.geeksforgeeks.arrays;

import java.util.HashMap;
import java.util.Map;

public class CheckIfArrayIsSortedAndRotated {

    public static void main(String[] args) {
        boolean result = CheckIfArrayIsSortedAndRotated.checkRotatedAndSorted(new int[]{3, 4, 1, 2}, 4);
        System.out.println("result = " + result);
        //30 20 10 50 25
    }

    public static boolean checkRotatedAndSorted(int[] arr, int num1) {
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        Map<Integer, Integer> map = new HashMap<>();
        int index = 0;
        for (int num : arr) {
            max = Math.max(max, num);
            min = Math.min(min, num);
            map.put(num, index);
            index++;
        }
       /* So How to Find, if array is Decreasingly or Increasingly Sorted in a Sorted and Rotated Array.

        Simple,

        If the positon of Max. Element is just before Min. Element, then it is Increasingly Sorted
        Else if position of Max. Element is just after Min. Element then it is Decreasingly Sorted,
        Else it is not sorted and rotated.

         */
        int indexMax = map.get(max);
        int indexMin = map.get(min);
        // System.out.println(indexMax);
        // System.out.println(indexMin);

        if ((indexMin == indexMax - 1)) {

            return checkIfSortedRotatedDecreasing(arr, indexMax, indexMin);
        } else if (indexMax == indexMin - 1) {
           /*   In case of Increasingly Sorted,

                Check if array is increasing upto Max. Element
                Check if array is increasing again after Min Element
                Check if Last Element is smaller than the first element

                In case of Decreasingly Sorted,

                Check if array is decreasing upto Min. Element
                Check if array is decreasing again after Max Element
                Check if Last Element is larger than the first element*/

            return checkIfSortedRotatedIncreasing(arr, indexMax, indexMin);
        }
        return false;

    }

    private static boolean checkIfSortedRotatedIncreasing(int[] arr, int indexMax, int indexMin) {
        for (int i = 1; i < indexMax; i++) {
            if (arr[i] <= arr[i - 1]) {
                return false;
            }
        }

        for (int i = indexMin + 1; i < arr.length - 1; i++) {
            if (arr[i + 1] <= arr[i]) {
                return false;
            }
        }
        return arr[arr.length - 1] <= arr[0];
    }

    private static boolean checkIfSortedRotatedDecreasing(int[] arr, int indexMax, int indexMin) {
        for (int i = 1; i < indexMin; i++) {
            if (arr[i] >= arr[i - 1]) {
                return false;
            }
        }
        for (int i = arr.length - 1; i > indexMax + 1; i--) {
            if (arr[i] >= arr[i - 1]) {
                return false;
            }
        }
        return arr[arr.length - 1] >= arr[0];
    }
}
