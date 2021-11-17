package com.leetcode;

import java.math.BigInteger;

public class ConcatenationOfConsecutiveBinaryNumbers {

    //TLE solution.
    public static void main(String[] args) {
        //1101110010111011110001001101010111100
        //1101110010111011110001001101010111100
        int result = new ConcatenationOfConsecutiveBinaryNumbers().concatenatedBinaryOptimized(123);
        System.out.println("result = " + result);
    }

    public int concatenatedBinary(int n) {

        int mod = 1000000000 + 7;
        StringBuilder sb = new StringBuilder();

        for (int i = 1; i <= n; i++) {
            sb.append(Integer.toBinaryString(i));
        }

        BigInteger number = new BigInteger(String.valueOf(sb), 2);

        BigInteger res = number.mod(BigInteger.valueOf(mod));

        return res.intValue();

    }

    public int concatenatedBinaryOptimized(int number) {

        int mod = 1000000000 + 7;
        long sum = 0;
        for (int i = 1; i <= number; i++) {
            sum = (sum * (int) Math.pow(2, Integer.toBinaryString(i).length()) + i) % mod;
        }

        return (int) sum;
    }

}
