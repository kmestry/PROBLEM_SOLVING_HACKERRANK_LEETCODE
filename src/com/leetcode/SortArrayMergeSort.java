package com.leetcode;

public class SortArrayMergeSort {

    public static void main(String[] args) {
        int[] result = new SortArrayMergeSort().sortArray(new int[]{5, 2, 3, 1});

        for (int i : result) {
            System.out.println("i = " + i);
        }
    }

    public int[] sortArray(int[] nums) {

        int length = nums.length;

        if (length == 1) return nums;

        int mid = (nums.length - 1) / 2;

        int[] left = new int[mid + 1];
        int[] right = new int[length - mid - 1];

        for (int i = 0; i < left.length; i++) {
            left[i] = nums[i];
        }

        int index = mid + 1;
        for (int i = 0; i < right.length; i++) {
            right[i] = nums[index];
            index++;
        }

        int[] leftArray = sortArray(left);
        int[] rightArray = sortArray(right);

        return merge(leftArray, rightArray);


    }

    private int[] merge(int[] leftArray, int[] rightArray) {
        int[] sortedArray = new int[leftArray.length + rightArray.length];

        int i = 0; // left Array pointer
        int j = 0; // right Array pointer
        int k = 0; //sortedArray pointer

        while (i < leftArray.length && j < rightArray.length) {

            if (leftArray[i] <= rightArray[j]) {
                sortedArray[k] = leftArray[i];
                k++;
                i++;
            } else {
                sortedArray[k] = rightArray[j];
                k++;
                j++;
            }
        }

        //add remaining elements from either of the left or right array
        while (i < leftArray.length) {
            sortedArray[k] = leftArray[i];
            k++;
            i++;
        }
        while (j < rightArray.length) {
            sortedArray[k] = rightArray[j];
            k++;
            j++;
        }

        return sortedArray;
    }
}
