package com.leetcode;

public class ArrangeCoins441 {

    // 1000000
    // 1000000000
    // 2147483647

    public static void main(String[] args) {
        int n = arrangeCoins(2147483647);
        System.out.println("n = " + n);

    }

    public static int arrangeCoins(int n) {
        long counter = 0;

        int numberOfStairCase = 0;
        for (int i = 1; i <= n; i++) {

            counter = counter + i;
            if (counter > n) {
                break;
            }
            numberOfStairCase++;
        }
        return numberOfStairCase;
    }
}
