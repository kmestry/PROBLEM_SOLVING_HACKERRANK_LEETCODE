package com.geeksforgeeks.arrays;

public class ReverseArray {

    public static void main(String[] args) {

        ReverseArray reverseArray = new ReverseArray();
        int[] arr = new int[]{30, 7, 6, 5, 10};
        reverseArray.reverse(arr);
        System.out.println("arr = " + arr);
    }

    // TC : O(N/2) == theta(N). constant space

    private void reverse(int[] array) {
        int left = 0;
        int right = array.length - 1;

        while (left < right) {
            int temp = array[left];
            array[left] = array[right];
            array[right] = temp;

            left++;
            right--;
        }

    }
}
