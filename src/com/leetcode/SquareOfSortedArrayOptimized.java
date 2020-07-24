package com.leetcode;

public class SquareOfSortedArrayOptimized {


    public static void main(String[] args) {


        int[] result = sortedSquares(new int[]{-7, -3, 2, 3, 11});

    }


    //[-7,-3,2,3,11]
    public static int[] sortedSquares(int[] A) {

        int[] result = new int[A.length];
        int leftPointer = 0;
        int rightPointer = A.length - 1;
        int indexTrackerOfResultArray = result.length - 1;

        while (leftPointer <= rightPointer) {
            int leftElement = Math.abs(A[leftPointer]);
            int rightElement = Math.abs(A[rightPointer]);

            if (leftElement < rightElement) {
                result[indexTrackerOfResultArray] = rightElement * rightElement;
                rightPointer--;
            } else {
                result[indexTrackerOfResultArray] = leftElement * leftElement;
                leftPointer++;

            }

            indexTrackerOfResultArray--;

        }

        return result;
    }
}
