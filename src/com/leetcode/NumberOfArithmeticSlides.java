package com.leetcode;

public class NumberOfArithmeticSlides {

    public static void main(String[] args) {
        new NumberOfArithmeticSlides().numberOfArithmeticSlices(new int[]{1, 2, 3, 8, 9, 10});
    }

    public int numberOfArithmeticSlices(int[] A) {

        int left = 0;
        int right = 2;
        int count = 0;
        int numOfElementsIndexBased = 2;
        while (numOfElementsIndexBased <= A.length - 1) {
            left = 0;
            right = numOfElementsIndexBased;
            while (right < A.length) {
                int inLeft = left;
                int inRight = left + 1;

                int diff = A[inRight] - A[inLeft];
                boolean isAP = true;
                while (inRight <= right) {
                    inLeft++;
                    inRight++;
                    if (inRight > right) break;
                    int newDiff = A[inRight] - A[inLeft];
                    if (newDiff != diff) {
                        isAP = false;
                        break;
                    }
                }

                if (isAP)
                    count++;
                left++;
                right++;
            }
            numOfElementsIndexBased++;
        }

        return count;
    }
}
