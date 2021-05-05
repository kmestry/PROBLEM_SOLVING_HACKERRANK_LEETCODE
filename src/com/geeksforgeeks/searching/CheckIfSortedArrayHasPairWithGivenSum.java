package com.geeksforgeeks.searching;

public class CheckIfSortedArrayHasPairWithGivenSum {

    // 2 pointer algorithm. works for sorted array,
    // for unsorted array use map approach to find pair.
    public static void main(String[] args) {

    }

    public int[] twoSum(int[] numbers, int target) {

        int[] result = new int[2];

        int low = 0;
        int high = numbers.length - 1;

        while (low < high) {
            if (numbers[low] + numbers[high] == target) {
                result[0] = low + 1;
                result[1] = high + 1;
                break;
            } else if (numbers[low] + numbers[high] > target) {
                high--;
            } else {
                low++;
            }
        }
        return result;
    }

}
