package com.leetcode;

public class CheckIfNAndItsDoubleExists {


    public static void main(String[] args) {
        boolean result = checkIfExist(new int[]{-2, 0, 10, -19, 4, 6, -8});
        System.out.println("result = " + result);
    }

    // arr = [10,2,5,3]
    //[7,1,14,11]
    public static boolean checkIfExist(int[] arr) {

        for (int i = 0; i < arr.length; i++) {

            int number = arr[i];
            int index = i;
            boolean result = checkIfDoubleExists(number * 2, arr, index);
            if (result) {
                return true;
            }


        }
        return false;


    }

    public static boolean checkIfDoubleExists(int number, int[] arr, int index) {

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == number && i != index) {
                return true;
            }
        }
        return false;
    }
}
