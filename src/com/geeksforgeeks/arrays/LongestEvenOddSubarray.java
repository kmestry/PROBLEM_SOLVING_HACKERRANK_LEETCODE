package com.geeksforgeeks.arrays;

public class LongestEvenOddSubarray {

    public static void main(String[] args) {
// 10 12 14 7 8
        LongestEvenOddSubarray longestEvenOddSubarray = new LongestEvenOddSubarray();
        int result = longestEvenOddSubarray.maxEvenOddSubArray(new int[]{5, 10, 20, 6, 3, 8});
        System.out.println("result = " + result);
    }

    private int maxEvenOddSubArray(int[] array) {

        int maxLength = 1;

        boolean isEven;

        for (int i = 0; i < array.length; i++) {

            int element = array[i];

            isEven = element % 2 == 0;

            int length = 1;
            for (int j = i + 1; j < array.length; j++) {

                int val = array[j];
                boolean isOdd = val % 2 == 1;
                if (isEven && isOdd) {
                    length++;
                } else if (!isEven && !isOdd) {
                    length++;
                } else {
                    break;
                }
                isEven = !isOdd;
            }
            maxLength = Math.max(maxLength, length);
        }
        return maxLength;
    }

}
