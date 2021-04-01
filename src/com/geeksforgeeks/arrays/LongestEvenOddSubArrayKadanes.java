package com.geeksforgeeks.arrays;

public class LongestEvenOddSubArrayKadanes {

    public static void main(String[] args) {
        // 10 12 14 7 8
        LongestEvenOddSubArrayKadanes longestEvenOddSubArrayKadanes = new LongestEvenOddSubArrayKadanes();
        int result = longestEvenOddSubArrayKadanes.longestEvenOdd(new int[]{10, 12, 14, 7, 8});
        System.out.println("result = " + result);

    }

    private int longestEvenOdd(int[] array) {

        int max = 1;
        int length = 1;

        for (int i = 1; i < array.length; i++) {

            if ((array[i - 1] % 2 == 0 && array[i] % 2 == 1)
                    || (array[i - 1] % 2 == 1 && array[i] % 2 == 0)) {

                length++;
                max = Math.max(length, max);

            } else {
                length = 1;
            }
        }
        return max;
    }
}
