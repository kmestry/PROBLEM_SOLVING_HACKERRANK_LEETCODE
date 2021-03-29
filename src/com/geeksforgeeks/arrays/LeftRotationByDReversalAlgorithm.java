package com.geeksforgeeks.arrays;

public class LeftRotationByDReversalAlgorithm {

    public static void main(String[] args) {

        LeftRotationByDReversalAlgorithm leftRotationByDReversalAlgorithm = new LeftRotationByDReversalAlgorithm();
        int[] array = new int[]{10, 5, 30, 15};
        leftRotationByDReversalAlgorithm.rotateByD(array, 3);
    }

    private void rotateByD(int[] array, int d) {


        d = d % array.length; // imp step if rotation is greater than array length
        reverse(array, 0, d - 1);
        reverse(array, d, array.length - 1);
        reverse(array, 0, array.length - 1);
    }

    private void reverse(int[] array, int low, int high) {

        while (low < high) {
            int temp = array[low];
            array[low] = array[high];
            array[high] = temp;

            low++;
            high--;
        }
    }
}
