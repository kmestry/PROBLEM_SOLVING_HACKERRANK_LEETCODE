package com.hackerrank.arrays;

public class LeftRotationInterviewPractise {
    // Complete the rotLeft function below.
    static int[] rotLeft(int[] a, int d) {

        for (int i = 0; i < d; i++) {
            int firstElement = a[0];
            for (int j = 0; j < a.length - 1; j++) {

                a[j] = a[j + 1];

            }
            a[a.length - 1] = firstElement;

        }

        return a;


    }

    public static void main(String[] args) {

        rotLeft(new int[]{1, 2, 3, 4, 5}, 2);
    }
}
