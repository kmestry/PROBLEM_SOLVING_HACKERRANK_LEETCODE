package com.leetcode;

public class ArrangeCoins441Solution {


    public static void main(String[] args) {
        int n = arrangeCoins(8);
        System.out.println("n = " + n);


        int m = arrangeCoins(10);
        System.out.println("m = " + m);

        int q = arrangeCoins(5);
        System.out.println("q = " + q);

    }

    public static int arrangeCoins(int n) {

        long left = 0;
        long right = n;
        long k, current;
        while (left <= right) {
            k = left + ((right - left) / 2);
            current = (k * (k + 1)) / 2;

            if (current == n) {
                return (int) k;
            }

            if (n < current) {
                right = k - 1;
            } else {
                left = k + 1;
            }
        }
        return (int) right;

    }
}

