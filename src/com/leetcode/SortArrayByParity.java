package com.leetcode;

public class SortArrayByParity {

    //  [3,1,2,4]
    public static void main(String[] args) {

        sortArrayByParity(new int[]{3, 1, 2, 4});
    }

    public static int[] sortArrayByParity(int[] A) {

        int[] result = new int[A.length];

        int evenPointer = 0;
        int oddPointer = result.length - 1;

        for (int i = 0; i < A.length; i++) {
            if (A[i] % 2 != 0) {
                result[oddPointer] = A[i];
                oddPointer--;
            } else {
                result[evenPointer] = A[i];
                evenPointer++;
            }
        }
        return result;


    }
}
