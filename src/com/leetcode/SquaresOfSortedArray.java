package com.leetcode;

import java.util.Arrays;
import java.util.PriorityQueue;

public class SquaresOfSortedArray {

    public static void main(String[] args) {
        int[] result = sortedSquareList(new int[]{-4, -1, 0, 3, 10});
        for (int i = 0; i < result.length; i++) {
            System.out.print(result[i] + " ");
        }
    }

    public static int[] sortedSquares(int[] A) {

        if (A[0] < 0) {

            for (int i = 0; i < A.length; i++) {
                int value = A[i];
                A[i] = value * value;
            }
            Arrays.sort(A);

        } else {
            for (int i = 0; i < A.length; i++) {
                A[i] = A[i] * A[i];
            }
        }
        return A;
    }


    public static int[] sortedSquareQueue(int[] A) {
        int[] result = new int[A.length];

        if (A[0] < 0) {
            PriorityQueue<Integer> integerPriorityQueue = new PriorityQueue<>();


            for (int i = 0; i < A.length; i++) {
                int value = A[i] * A[i];
                integerPriorityQueue.add(value);
            }


            int counter = 0;
            while (!integerPriorityQueue.isEmpty()) {
                result[counter] = integerPriorityQueue.poll();
                counter++;
            }
            return result;
        } else {
            for (int i = 0; i < A.length; i++) {
                result[i] = A[i] * A[i];
            }
        }
        return result;
    }

    // -11 -4, -1, 0, 3, 10
    public static int[] sortedSquareList(int[] A) {
        int[] result = new int[A.length];
        int leftPointer = 0;
        int rightPointer = A.length - 1;

        int counter = result.length - 1;
        for (int i = 0; i < A.length; i++) {

            if (Math.abs(A[leftPointer]) > Math.abs(A[rightPointer])) {
                int square = A[leftPointer] * A[leftPointer];
                result[counter] = square;
                leftPointer += 1;
                counter--;
            } else {
                int square = A[rightPointer] * A[rightPointer];
                result[counter] = square;
                rightPointer -= 1;
                counter--;
            }

        }
        return result;

    }

}
