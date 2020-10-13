package com.hackerrank.hackerfest.october10;

import java.io.IOException;

public class CyclicBinaryStringsOptimized {

    public static void main(String[] args) throws IOException {
        CyclicBinaryStrings cyclicBinaryStrings = new CyclicBinaryStrings();
        int result = CyclicBinaryStringsOptimized.maximumPower("1010011101011010010101101111011");
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

    public static boolean areAllBitsUnSet(String binaryString) {
        // all bits are not set

        for (int i = 0; i < binaryString.length(); i++) {
            char c = binaryString.charAt(i);
            if (c != '0') {
                return false;
            }
        }
        return true;

    }

    //0011
    public static int maximumPower(String binaryString) {

        //String binaryString = "0011";
        int maxPowerOfTwo = -1;

        if (areAllBitsUnSet(binaryString))
            return -1;

        if (areAllBitsSet(binaryString)) {
            return getMaxPowerOfTwo(-1, binaryString);
        }

        for (int i = 0; i < binaryString.length(); i++) {


            char c = binaryString.charAt(binaryString.length() - 1);

            StringBuilder sb = new StringBuilder(binaryString);
            sb.deleteCharAt(binaryString.length() - 1);

            String rotatedString = c + sb.toString();


            maxPowerOfTwo = getMaxPowerOfTwo(maxPowerOfTwo, rotatedString);

            binaryString = rotatedString;
        }

        return maxPowerOfTwo;
    }

    private static int getMaxPowerOfTwo(int maxPowerOfTwo, String rotatedString) {
        //first step to check if it divides by 1.
        // maxPowerOfTwo = Math.max(maxPowerOfTwo, 0);

        int numOfZeros = 0;

        for (int i = rotatedString.length() - 1; i >= 0; i--) {

            if (rotatedString.charAt(i) == '0') {
                numOfZeros++;
            } else {
                break;
            }
        }

        return Math.max(numOfZeros, maxPowerOfTwo);
    }
}
