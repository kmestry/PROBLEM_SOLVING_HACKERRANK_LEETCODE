package com.geeksforgeeks.arrays;

public class MoveZerosToEndBestApproach {
    public static void main(String[] args) {
        MoveZerosToEndBestApproach moveZerosToEndBestApproach = new MoveZerosToEndBestApproach();
        int[] array = new int[]{0, 0, 0, 0, 8, 0, 9, 0};
        moveZerosToEndBestApproach.moveZerosToEnd(array);
    }

    private void moveZerosToEnd(int[] array) {

        int count = 0;

        for (int i = 0; i < array.length; i++) {

            if (array[i] != 0) {
                int temp = array[i];
                array[i] = array[count];
                array[count] = temp;
                count++;
            }
        }
    }
}
