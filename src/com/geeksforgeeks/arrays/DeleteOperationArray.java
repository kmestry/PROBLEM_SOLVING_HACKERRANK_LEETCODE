package com.geeksforgeeks.arrays;

public class DeleteOperationArray {
    public static void main(String[] args) {

        DeleteOperationArray deleteOperationArray = new DeleteOperationArray();
        int[] arr = new int[]{3, 8, 12, 5, 6};
        deleteOperationArray.delete(12, arr);
        System.out.println("arr = " + arr);

    }

    private void delete(int element, int[] array) {

        int index = -1;
        for (int i = 0; i < array.length; i++) {
            if (element == array[i]) {
                index = i;
                break;
            }
        }

        if (index == -1) return;

        for (int i = index; i < array.length - 1; i++) {
            array[i] = array[i + 1];
        }
        array[array.length - 1] = 0;
    }
}
