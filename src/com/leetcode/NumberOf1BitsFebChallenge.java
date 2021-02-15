package com.leetcode;

public class NumberOf1BitsFebChallenge {

    public static void main(String[] args) {
        new NumberOf1BitsFebChallenge().hammingWeight(11);
    }

    public int hammingWeight(int n) {
        String val = Integer.toBinaryString(n);

        System.out.println("val = " + val);
        int count = 0;

        char[] chars = val.toCharArray();
        for (char c : chars) {
            if (c == '1') {
                count++;
            }
        }

        return count;
    }

    public int hammingWeightBitOperation(int n) {

        int count = 0;

        for (int i = 0; i < 32; i++) {
            if ((n >> i & 1) == 1) {
                count++;
            }
        }

        return count;
    }

    public int hammingWeightBitApproach2(int n) {
        int count = 0;
        while (n != 0) {
            n = n & n - 1;
            count++;
        }

        return count;

        //  Integer.bitCount(n); in built library approach.
    }
}
