package com.geeksforgeeks.arrays;

import java.util.Arrays;

public class SmallestMissingPositiveNumber {

    public static void main(String[] args) {
        SmallestMissingPositiveNumber smallestMissingPositiveNumber = new SmallestMissingPositiveNumber();
        // int result = smallestMissingPositiveNumber.missingNumber(new int[]{28, 7, -36, 21, -21, -50, 9, -32}, 8);
        int result1 = smallestMissingPositiveNumber.missingNumber(new int[]{0, 1}, 2);

        System.out.println("result = " + result1);
    }

    int missingNumber(int[] arr, int size) {

        // Your code here
        // You can add utility functions (if required)

        int[] auxArr = new int[arr.length];

        int index = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > 0) {
                auxArr[index] = arr[i];
                index++;
            }
        }

        int[] copyArr = new int[index];
        for (int i = 0; i < index; i++) {
            copyArr[i] = auxArr[i];
        }
        Arrays.sort(copyArr);


        if (copyArr.length == 0 || copyArr[0] > 1) {
            return 1;
        }

        for (int i = 1; i < index; i++) {
            if (copyArr[i] > (copyArr[i - 1] + 1)) {
                return copyArr[i - 1] + 1;
            }
        }
        if (copyArr.length == 0) return 1;
        return copyArr[index - 1] + 1;
    }
}
