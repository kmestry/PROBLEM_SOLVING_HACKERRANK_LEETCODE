package com.leetcode;

public class ReverseBits190 {

    public static int reverseBits(int n) {
        String binaryString = Integer.toBinaryString(n);
        System.out.println("binaryString = " + binaryString);
        int numberOfBitsToPad = 32 - binaryString.length();
        for (int i = 0; i < numberOfBitsToPad; i++) {
            binaryString = "0" + binaryString;
        }
        System.out.println("binaryStringPadded = " + binaryString);


        StringBuilder stringBuilder = new StringBuilder(binaryString);
        String reversedStringBits = stringBuilder.reverse().toString();
        System.out.println("reversedStringBits = " + reversedStringBits);
        //long result = binaryToIntegerConverter(reversedStringBits);

        // System.out.println("result = " + result);


        return Integer.parseUnsignedInt(reversedStringBits, 2);


    }

    public static long binaryToIntegerConverter(String binaryString) {
        int counter = 0;
        long result = 0;
        for (int i = binaryString.length() - 1; i >= 0; i--) {
            result = result + (((int) Math.pow(2, counter)) * (binaryString.charAt(i) == 48 ? 0 : 1));
            counter++;
        }
        return result;

    }

    public static void main(String[] args) {

        int result = reverseBits(-3);
        System.out.println("result = " + result);
        //00000010100101000001111010011100
        //00000010100101000001111010011100

        //00111001011110000010100101000000

        // System.out.println("Integer.parseInt(\"10111111111111111111111111111111\",2) = " + Long.parseLong("10111111111111111111111111111111",2));
    }
}
