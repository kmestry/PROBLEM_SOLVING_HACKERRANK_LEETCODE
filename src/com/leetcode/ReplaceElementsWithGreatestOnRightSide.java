package com.leetcode;

public class ReplaceElementsWithGreatestOnRightSide {

    public static void main(String[] args) {

        int[] result = replaceElements(new int[]{17, 18, 5, 4, 6, 1});
        for (int i = 0; i < result.length; i++) {
            System.out.print(result[i] + " ");
        }
    }

    //[17,18,5,4,6,1]
    public static int[] replaceElements(int[] arr) {

        for (int i = 0; i < arr.length - 1; i++) {

            int index = findRightLargestAndReplaceArray(i, arr);

            arr[i] = arr[index];

        }
        arr[arr.length - 1] = -1;
        return arr;

    }

    public static int findRightLargestAndReplaceArray(int index, int[] array) {

        int maxElement = 0;
        int indexMax = 0;
        for (int i = index + 1; i < array.length; i++) {
            if (array[i] > maxElement) {
                maxElement = array[i];
                indexMax = i;
            }
        }
        return indexMax;
    }
}
