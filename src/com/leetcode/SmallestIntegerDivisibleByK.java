package com.leetcode;

public class SmallestIntegerDivisibleByK {

    public static void main(String[] args) {
        int count = new SmallestIntegerDivisibleByK().smallestRepunitDivByK(323);
        System.out.println("count = " + count);
    }

    public int smallestRepunitDivByK(int K) {

        if (K % 10 == 0 || K % 10 == 2 || K % 10 == 4 || K % 10 == 6 || K % 10 == 8 || K % 10 == 5) {
            return -1;
        }

        int N = 1;
        int length = 1;
        while (true) {

            if (N % K == 0) {
                return length;
            }
            N = (N * 10 + 1) % K;
            length++;
        }


    }
}
