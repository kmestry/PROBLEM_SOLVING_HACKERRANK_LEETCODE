package com.leetcode;

public class FindNumbersWithEvenNumberOfDigits1295 {
    public static void main(String[] args) {

    }

    public static boolean hasEvenNumberOfDigits(int number) {
        int counter = 0;
        while (number > 0) {
            number /= 10;
            counter++;
        }
        return counter % 2 == 0;
    }

    // [12,345,2,6,7896]
    public static int findNumbers(int[] nums) {

        int counter = 0;
        for (int i = 0; i < nums.length; i++) {

            if (hasEvenNumberOfDigits(nums[i]))
                counter++;

        }
        return counter;
    }
}
