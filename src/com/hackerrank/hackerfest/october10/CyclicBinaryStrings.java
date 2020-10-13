package com.hackerrank.hackerfest.october10;

import java.io.IOException;

public class CyclicBinaryStrings {

    public static void main(String[] args) throws IOException {
        CyclicBinaryStrings cyclicBinaryStrings = new CyclicBinaryStrings();
        int result = maximumPower("11111111111101111000000111101011");
        System.out.println("result = " + result);
    }

    public static boolean areAllBitsSet(String binaryString) {
        // all bits are not set

        for (int i = 0; i < binaryString.length(); i++) {
            char c = binaryString.charAt(i);
            if (c != '1') {
                return false;
            }
        }
        return true;

    }

    //0011
    public static int maximumPower(String binaryString) {

        //String binaryString = "0011";
        int maxPowerOfTwo = -1;

        if (Long.parseLong(binaryString, 2) == 0)
            return -1;

        if (areAllBitsSet(binaryString)) {
            return getMaxPowerOfTwo(-1, (int) Long.parseLong(binaryString, 2));
        }

        for (int i = 0; i < binaryString.length(); i++) {


            char c = binaryString.charAt(binaryString.length() - 1);

            StringBuilder sb = new StringBuilder(binaryString);
            sb.deleteCharAt(binaryString.length() - 1);

            String rotatedString = c + sb.toString();

            int value = (int) Long.parseLong(rotatedString, 2);

            maxPowerOfTwo = getMaxPowerOfTwo(maxPowerOfTwo, value);

            System.out.println("rotatedString = " + rotatedString);
            binaryString = rotatedString;
        }

        return maxPowerOfTwo;
    }

    private static int getMaxPowerOfTwo(int maxPowerOfTwo, int value) {
        //first step to check if it divides by 1.
        if (value % Math.pow(2, 0) == 0) {
            maxPowerOfTwo = Math.max(maxPowerOfTwo, 0);
        }

        int power = 1;
        while (value % Math.pow(2, power) == 0) {
            maxPowerOfTwo = Math.max(maxPowerOfTwo, power);
            power++;
        }
        return maxPowerOfTwo;
    }
}
// 001

// 100
// 010
// 001