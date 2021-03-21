package com.geeksforgeeks.arrays;

public class SecondLargestElementArray {
    public static void main(String[] args) {

        SecondLargestElementArray secondLargestElementArray = new SecondLargestElementArray();
        int result = secondLargestElementArray.secondLargestElement(new int[]{10, 10, 10});
        System.out.println("result = " + result);
    }

    private int secondLargestElement(int[] arr) {
        int max = Integer.MIN_VALUE;


        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];

            }
        }

        int secondLargest = Integer.MIN_VALUE;
        int secondLargestIndex = -1;
        for (int i = 0; i < arr.length; i++) {
            if (max == arr[i]) continue;
            if (arr[i] > secondLargest) {
                secondLargest = arr[i];
                secondLargestIndex = i;
            }
        }

        return secondLargestIndex;
    }
}
