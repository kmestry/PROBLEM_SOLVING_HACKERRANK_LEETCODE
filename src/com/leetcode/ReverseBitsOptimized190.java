package com.leetcode;

public class ReverseBitsOptimized190 {

    public static int reverseBits(int n) {

        int result = 0;
        for (int i = 0; i < 32; i++) {
            result <<= 1;
            result += n % 2;
            n >>>= 1;
        }
        return result;
    }

    public static void main(String[] args) {
        int result = reverseBits(14);
        System.out.println("result = " + result);
    }
}
