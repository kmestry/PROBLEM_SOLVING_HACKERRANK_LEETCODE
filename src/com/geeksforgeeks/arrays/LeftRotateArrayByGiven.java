package com.geeksforgeeks.arrays;

public class LeftRotateArrayByGiven {

    public static void main(String[] args) {

        LeftRotateArrayByGiven leftRotateArrayByGiven = new LeftRotateArrayByGiven();
        int[] array = new int[]{10, 5, 30, 15};
        leftRotateArrayByGiven.leftRotate(array, 3);
    }
    //Time complexity.
    // theta(N) and theta(D) auxiliary space.

    private void leftRotate(int[] array, int d) {

        int[] tempArray = new int[d];

        for (int i = 0; i < d; i++) {
            tempArray[i] = array[i];
        }

        int index = 0;
        for (int i = d; i < array.length; i++) {
            array[index] = array[i];
            index++;
        }

        int startIndex = array.length - d;
        int tempIndex = 0;
        for (int i = startIndex; i < array.length; i++) {
            array[i] = tempArray[tempIndex];
            tempIndex++;
        }
    }
}
