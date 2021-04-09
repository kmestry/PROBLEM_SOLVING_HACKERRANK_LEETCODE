package com.geeksforgeeks.arrays;

public class MinimumConsecutiveFlips {

    public static void main(String[] args) {

        MinimumConsecutiveFlips minimumConsecutiveFlips = new MinimumConsecutiveFlips();
        minimumConsecutiveFlips.minimumConsecutiveFlips(new int[]{1, 0, 0, 0, 1, 0, 0, 1, 1, 1, 1});
        minimumConsecutiveFlips.minimumConsecutiveFlips(new int[]{0, 1});
        minimumConsecutiveFlips.minimumConsecutiveFlips(new int[]{1, 1});
        minimumConsecutiveFlips.minimumConsecutiveFlips(new int[]{1, 1, 0, 0, 0, 1});
    }

    // 1, 1, 0, 0, 0, 1
    private void minimumConsecutiveFlips(int[] array) {

        int countConsecutiveOnes = 0;
        int countConsecutiveZeros = 0;


        for (int i = 0; i < array.length - 1; i++) {

            if (array[i] != array[i + 1] && array[i + 1] == 0) {
                countConsecutiveOnes++;
            }
            if (array[i] != array[i + 1] && array[i + 1] == 1) {
                countConsecutiveZeros++;
            }
        }
        if (array[array.length - 1] == 0) {
            countConsecutiveZeros++;
        } else {
            countConsecutiveOnes++;
        }

        boolean isMinimumValueOne = countConsecutiveOnes < countConsecutiveZeros;

        printRange(array, isMinimumValueOne ? 1 : 0);

    }

    private void printRange(int[] array, int minValue) {

        int rangeStart = -1;
        for (int i = 0; i < array.length; i++) {
            if (array[i] == minValue && rangeStart == -1) {
                rangeStart = i;
            } else if (array[i] != minValue && rangeStart > -1) {
                System.out.println("From " + rangeStart + " to " + (i - 1));
                rangeStart = -1;
            }

        }
        if (rangeStart != -1) {
            System.out.println("From " + rangeStart + " to " + (array.length - 1));
        }
    }


}
