package com.geeksforgeeks.arrays;

public class ArrayInsertAtIndex {

    public static void main(String[] args) {

        ArrayInsertAtIndex arrayInsertAtIndex = new ArrayInsertAtIndex();
        arrayInsertAtIndex.insertAtIndex(new int[]{1, 2, 3, 4, 5, 0}, 6, 2, 90);
    }

    public void insertAtIndex(int[] arr, int sizeOfArray, int index, int element) {
        //Your code here, Geeks


        for (int i = sizeOfArray - 1; i > index; i--) {

            arr[i] = arr[i - 1];
        }


        arr[index] = element;
    }
}
