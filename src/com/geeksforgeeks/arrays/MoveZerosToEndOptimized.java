package com.geeksforgeeks.arrays;

public class MoveZerosToEndOptimized {
    public static void main(String[] args) {
        MoveZerosToEndOptimized moveZerosToEndOptimized = new MoveZerosToEndOptimized();
        int[] arr = new int[]{0, 0, 0, 0, 8, 0, 9, 0};
        moveZerosToEndOptimized.moveZerosToEnd(arr);
        System.out.println("arr = " + arr);
    }

    // 10 5 0 0 8 0 9 0
    //Better approach but TLE. O(N^2)
    private void moveZerosToEnd(int[] array) {

        for (int i = 0; i < array.length; i++) {

            if (array[i] == 0) {

                for (int j = i + 1; j < array.length; j++) {
                    if (array[j] != 0) {
                        int temp = array[j];
                        array[j] = array[i];
                        array[i] = temp;
                        break;

                    }
                }
            }
        }
    }
}
