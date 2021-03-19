package com.geeksforgeeks.arrays;

public class LargestElementArray {

    public static void main(String[] args) {
        LargestElementArray largestElementArray = new LargestElementArray();
        int result = largestElementArray.findLargestElementIndex(new int[]{40, 8, 50, 100});
        System.out.println("result = " + result);
    }

    private int findLargestElementIndex(int[] array) {
        int max = Integer.MIN_VALUE;
        int index = -1;

        for (int i = 0; i < array.length; i++) {
            if (array[i] > max) {
                max = array[i];
                index = i;
            }
        }

        return index;
    }
}
