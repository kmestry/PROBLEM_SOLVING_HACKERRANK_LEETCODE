package com.geeksforgeeks.arrays;

public class RemoveDuplicatesFromSortedArray {
    public static void main(String[] args) {
        RemoveDuplicatesFromSortedArray removeDuplicatesFromSortedArray = new RemoveDuplicatesFromSortedArray();
        int result = removeDuplicatesFromSortedArray.removeDuplicatesAndReturnSize(new int[]{10, 20, 20, 30, 30, 30, 30});
        // int result = removeDuplicatesFromSortedArray.removeDuplicatesAndReturnSize(new int[]{10, 10, 10});
        System.out.println("result = " + result);
    }

    // Same array is modified with distinct elements present till the method return value.
    private int removeDuplicatesAndReturnSize(int[] array) {

        int result = 1;

        for (int i = 1; i < array.length; i++) {

            if (array[i] != array[i - 1]) {
                array[result] = array[i];
                result++;
            }

        }
        return result;
    }
}
