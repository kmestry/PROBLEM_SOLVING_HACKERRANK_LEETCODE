package com.geeksforgeeks.arrays;

public class LeftRotateAnArrayByOne {
    public static void main(String[] args) {

        LeftRotateAnArrayByOne leftRotateAnArrayByOne = new LeftRotateAnArrayByOne();
        int[] array = new int[]{1, 2, 3, 4, 5};
        leftRotateAnArrayByOne.leftRotate(array);
    }

    private void leftRotate(int[] array) {

        int temp = array[0];

        for (int i = 1; i < array.length; i++) {
            array[i - 1] = array[i];
        }

        array[array.length - 1] = temp;
    }
}
