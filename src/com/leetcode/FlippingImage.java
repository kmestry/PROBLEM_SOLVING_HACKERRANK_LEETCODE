package com.leetcode;

public class FlippingImage {

    public int[][] flipAndInvertImage(int[][] A) {
        int row = A.length;
        int col = A[0].length;
        int[][] result = new int[row][col];

        for (int i = 0; i < A.length; i++) {

            int[] innerArray = A[i];

            int[] flip = new int[innerArray.length];

            int flipIndex = 0;
            for (int j = innerArray.length - 1; j >= 0; j--) {
                flip[flipIndex] = innerArray[j];
                flipIndex++;
            }

            int[] invert = new int[flip.length];

            for (int k = 0; k < flip.length; k++) {
                if (flip[k] == 0) {
                    invert[k] = 1;
                } else {
                    invert[k] = 0;
                }
            }

            result[i] = invert;

        }

        return result;
    }

    public int[][] flipAndInvertImage2Pointer(int[][] A) {
        int row = A.length;
        int col = A[0].length;

        //two pointer approach , if left == right flip
        //else continue

        for (int i = 0; i < col; i++) {
            int[] innerArray = A[i];
            int left = 0;
            int right = innerArray.length - 1;

            while (left <= right) {
                if (innerArray[left] == innerArray[right]) {
                    if (innerArray[left] == 0) {
                        innerArray[left] = 1;
                        innerArray[right] = 1;
                    } else {
                        innerArray[left] = 0;
                        innerArray[right] = 0;
                    }
                }
                left++;
                right--;

            }

        }

        return A;
    }
}
