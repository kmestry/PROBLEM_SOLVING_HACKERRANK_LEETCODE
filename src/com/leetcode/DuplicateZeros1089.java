package com.leetcode;

public class DuplicateZeros1089 {

    public static void main(String[] args) {
        duplicateZeros(new int[]{0, 0, 0, 0, 0, 0, 0});
    }

    public static void duplicateZeros(int[] arr) {

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 0) {
                if (i == arr.length - 1) break;
                rightShiftElements(arr, i + 1);
                i = i + 1;

            }
        }
    }

    public static void rightShiftElements(int[] array, int startIndex) {
// 2 3 0 4 5 0
//   2 3 0 4 5
        int pointer = array[startIndex];
        int temporaryVariable;
        array[startIndex] = 0;
        for (int i = startIndex + 1; i < array.length; i++) {
            temporaryVariable = array[i];
            array[i] = pointer;
            pointer = temporaryVariable;

        }

    }
}
