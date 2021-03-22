package com.geeksforgeeks.arrays;

public class MoveZerosToEnd {

    public static void main(String[] args) {

        MoveZerosToEnd moveZerosToEnd = new MoveZerosToEnd();
        int[] result = moveZerosToEnd.moveZerosToEnd(new int[]{10, 20});
    }

    // using auxiliary extra space.
    private int[] moveZerosToEnd(int[] array) {

        int[] result = new int[array.length];
        int index = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] != 0) {
                result[index] = array[i];
                index++;
            }
        }

        return result;
    }
}
