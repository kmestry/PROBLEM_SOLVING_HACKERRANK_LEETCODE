package com.hackerrank.hackerfest.october10;

import java.io.IOException;

public class CyclicBinaryStringsOptimized2 {

    public static void main(String[] args) throws IOException {
        CyclicBinaryStrings cyclicBinaryStrings = new CyclicBinaryStrings();
        //int result = CyclicBinaryStringsOptimized2.maximumPower("000001000001");

        int res_1 = CyclicBinaryStringsOptimized2.maxConsecutiveZerosInBinary("1010011101011010010101101111011");
        System.out.println("res_1 = " + res_1);
        // System.out.println("result = " + result);
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


    public static int maximumPower(String binaryString) {

        if (binaryString.length() > 33) return -1;

        if (areAllBitsUnSet(binaryString))
            return -1;


        int maxPower = 0;
        for (int i = 0; i < binaryString.length(); i++) {
            char c = binaryString.charAt(i);
            if (c == '0') {
                int count = 1;
                maxPower = Math.max(maxPower, 1); //first 0 .
                for (int j = i + 1; j < binaryString.length(); j++) {
                    char c1 = binaryString.charAt(j);
                    if (c1 == '0') {
                        count++;

                    } else {
                        maxPower = Math.max(count, maxPower);
                        i = j;
                        break;
                    }
                    i = j;
                    maxPower = Math.max(count, maxPower);
                }
            }
        }

        return maxPower;
    }

    private static int maxConsecutiveZerosInBinary(String binaryString) {


        String[] s2 = binaryString.substring(0, binaryString.lastIndexOf('1')).split("1");
        int maxConsecutiveZeros = 0;

        for (int i = 0; i < s2.length; i++) {
            maxConsecutiveZeros = Math.max(maxConsecutiveZeros, s2[i].length());
        }

        return maxConsecutiveZeros;
    }
}
