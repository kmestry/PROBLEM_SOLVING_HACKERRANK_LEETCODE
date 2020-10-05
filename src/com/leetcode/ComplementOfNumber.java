package com.leetcode;

public class ComplementOfNumber {

    public int bitwiseComplement(int N) {

        int power = 1;
        int result = 0;

        if (N == 0) return 1;

        while (N > 0) {

            int rightMostBit = N & 1;

            //0 as we need to consider complement.
            if (rightMostBit == 0) {
                result += power; // result += 1 * power;   similar to 2^0 .. 2^1 .. 2^2. when converting binary string to number.
            }
            N = N >> 1; //right shift by 1 to consider the next bit and perform opertation.

            power *= 2;
        }

        return result;
    }
}
