package com.leetcode;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MergeTwoSortedArrayInPlace {


    /*   2
       4 5
       1 3 5 7
       0 2 6 8 9
       2 3
       10 12
       5 18 20*/
    public static void main(String[] args) throws IOException {
        //code
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int numberOfTestCases = Integer.parseInt(bufferedReader.readLine().trim());

        for (int i = 0; i < numberOfTestCases; i++) {
            String[] sizeOfArrays = bufferedReader.readLine().split(" ");
            int firstArraySize = 0;
            int secondArraySize = 0;

            firstArraySize = Integer.parseInt(sizeOfArrays[0]);
            secondArraySize = Integer.parseInt(sizeOfArrays[1]);

            String[] firstArrayElements = bufferedReader.readLine().split(" ");
            int[] firstArray = new int[firstArrayElements.length];

            for (int k = 0; k < firstArrayElements.length; k++) {
                firstArray[k] = Integer.parseInt(firstArrayElements[k]);
            }

            String[] secondArrayElements = bufferedReader.readLine().split(" ");
            int[] secondArray = new int[secondArrayElements.length];

            for (int j = 0; j < secondArrayElements.length; j++) {
                secondArray[j] = Integer.parseInt(secondArrayElements[j]);
            }

            mergeSortedArray(firstArray, secondArray, firstArraySize, secondArraySize);

            for (int num : firstArray) {
                System.out.print(num + " ");
            }
            for (int num2 : secondArray) {
                System.out.print(num2 + " ");
            }

            System.out.println();

        }
    }

    public static void mergeSortedArray(int[] firstArray, int[] secondArray, int firstArraySize, int secondArraySize) {
        int totalSize = firstArraySize + secondArraySize;
        double gap = (int) Math.ceil((double) totalSize / 2);

        int counter = 0;
        while (gap >= 1) {
            if (counter == 1) break;
            if (gap == 1) {
                counter++;
            }
            int firstPointer = 0;
            int secondPointer = (int) (gap + firstPointer);

            while (secondPointer < firstArraySize + secondArraySize) {

                if (firstPointer > firstArraySize - 1) {
                    int diff = firstPointer - firstArraySize;
                    final int abs = (int) (diff + gap);
                    if (secondArray[diff] > secondArray[abs]) {
                        int temp = secondArray[diff];
                        secondArray[diff] = secondArray[abs];
                        secondArray[abs] = temp;

                    }
                } else if (secondPointer > firstArraySize - 1) {
                    int diff = secondPointer - firstArraySize;
                    if (firstArray[firstPointer] > secondArray[diff]) {
                        int temp = firstArray[firstPointer];
                        firstArray[firstPointer] = secondArray[diff];
                        secondArray[diff] = temp;

                    }
                } else {
                    if (firstArray[firstPointer] > firstArray[secondPointer]) {
                        int temp = firstArray[firstPointer];
                        firstArray[firstPointer] = firstArray[secondPointer];
                        firstArray[secondPointer] = temp;

                    }
                }
                firstPointer++;
                secondPointer++;
            }
            gap = Math.ceil(gap / (double) 2);

        }


    }
}
