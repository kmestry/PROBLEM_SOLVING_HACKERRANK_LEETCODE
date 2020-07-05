package com.leetcode;

public class HammingDistance461 {

    public static void main(String[] args) {
        hammingDistance(1, 4);
        Integer.bitCount(3 ^ 5);
    }

    public static int hammingDistance(int x, int y) {
        String xBinaryString = convertToBinaryString(x);
        String yBinaryString = convertToBinaryString(y);

        String bigString = "";
        String smallString = "";
        if (xBinaryString.length() >= yBinaryString.length()) {
            bigString = xBinaryString;
            smallString = yBinaryString;
        } else if (xBinaryString.length() < yBinaryString.length()) {
            bigString = yBinaryString;
            smallString = xBinaryString;
        }
        String smallStringModified = makeStringsEqual(bigString, smallString);
        assert smallStringModified.length() == bigString.length();
        int counter = 0;
        for (int i = 0; i < bigString.length(); i++) {
            if ((smallStringModified.charAt(i) ^ bigString.charAt(i)) == 1) {
                counter++;
            }
        }
        return counter;
    }

    public static String makeStringsEqual(String bigString, String smallString) {
        int lengthDifference = bigString.length() - smallString.length();
        for (int i = 0; i < lengthDifference; i++) {
            smallString = "0" + smallString;
        }
        return smallString;

    }

    public static String convertToBinaryString(int number) {
        String binaryString = "";
        while (number != 0) {
            int bitBinary = number % 2;
            binaryString = bitBinary + binaryString;
            number /= 2;

        }
        System.out.println("binaryString===" + binaryString);
        return binaryString;
    }
}
