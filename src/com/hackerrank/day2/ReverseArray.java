package com.hackerrank.day2;

public class ReverseArray {

    // Complete the reverseArray function below.
    //1 2 3 4

    /*Hi hackers, my java submission :::  int[] result = new int[a.length];int indexCounter = 0;for (int i = a.length - 1; i >= 0; i--) {  int value = a[i];result[indexCounter] = value;indexCounter++; return result;*/

    static int[] reverseArray(int[] a) {

        int[] result = new int[a.length];
        int indexCounter = 0;
        for (int i = a.length - 1; i >= 0; i--) {

            int value = a[i];
            result[indexCounter] = value;
            indexCounter++;

        }
        return result;
    }

    public static void main(String[] args) {

        System.out.println("args = " + reverseArray(new int[]{1, 2, 3, 4}));
    }
}
