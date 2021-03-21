package com.geeksforgeeks.arrays;

public class CheckIfArrayIsSorted {

    public static void main(String[] args) {

        CheckIfArrayIsSorted checkIfArrayIsSorted = new CheckIfArrayIsSorted();
        boolean result = checkIfArrayIsSorted.checkIfSorted(new int[]{8});
        System.out.println("result = " + result);
    }

    private boolean checkIfSorted(int[] array) {

        for (int i = 1; i < array.length; i++) {
            if (array[i] < array[i - 1]) {
                return false;
            }
        }
        return true;
    }
}
