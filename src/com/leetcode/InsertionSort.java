package com.leetcode;

public class InsertionSort {

    public static void main(String[] args) {

        new InsertionSort().sortArray(new int[]{8});
    }

    // 8 2 4 1 3
    // 2 8 4 1 3
    // 2 4 8 1 3

    private void sortArray(int[] inArray) {

        for (int i = 0; i < inArray.length; i++) {

            int current = inArray[i];

            int leftCounter = i - 1;
            int counter = i;

            while (leftCounter >= 0 && current < inArray[leftCounter]) {
                int temp = inArray[leftCounter];
                inArray[leftCounter] = current;
                inArray[counter] = temp;
                leftCounter--;
                counter--;

            }
        }

    }
}
