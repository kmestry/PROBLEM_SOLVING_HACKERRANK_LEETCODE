package com.leetcode;

public class HammingDistanceBrianKernighan461 {


    public static void main(String[] args) {

        hammingDistance(1, 4);

    }

    public static int hammingDistance(int x, int y) {
        //get xor so that we get the set bits in the number. 1 xor 0 and 0 xor 1 is 1 . 0 xor 0 and 1 xor 1 is 0 .
        int value = x ^ y;
        int counter = 0;

        while (value != 0) {
            value = value & (value - 1); //brian kernighan algorithm num & num-1 will unset the rightmost set bit.
            counter++;
        }

        return counter;

    }

}

