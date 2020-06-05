package com.hackerrank.algorithms.bitmanipulation;

import java.io.IOException;
import java.util.Scanner;
import java.util.Stack;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class FlippingBits {

    private static final Scanner scanner = new Scanner(System.in);

    // Complete the flippingBits function below.
    static long flippingBits(long n) {

        String binaryString = decimalToBinary(n);

        String flippedBinaryString = flipBinaryString(binaryString);

        Long result = binaryToLong(flippedBinaryString);

        return result;
    }

    static String decimalToBinary(long number) {
        Stack<Long> binaryBitStack = new Stack<>();
        while (number > 0) {
            long remainder = number % 2;
            binaryBitStack.push(remainder);
            number = number / 2;
        }
        StringBuilder binaryString = new StringBuilder();
        while (!binaryBitStack.isEmpty()) {
            binaryString.append(binaryBitStack.pop());

        }
        int remainingStringToFill = 32 - binaryString.length();
        String remainingString = "0";
        //remainingString.repeat(remainingStringToFill);
        String repeatedString = IntStream.range(0, remainingStringToFill).mapToObj(i -> remainingString).collect(Collectors.joining(""));

        String binaryResult = repeatedString + binaryString;
        return binaryResult;
    }

    static String flipBinaryString(String stringToFlip) {
        String flippedString = "";

        for (int i = 0; i < stringToFlip.length(); i++) {
            if (stringToFlip.charAt(i) == 48)
                flippedString += "1";
            else
                flippedString += "0";
        }
        return flippedString;


    }

    static Long binaryToLong(String binaryString) {
        StringBuilder stringBuilder = new StringBuilder(binaryString);
        String binaryStringReversed = stringBuilder.reverse().toString();

        long result = 0l;
        for (int i = 0; i < binaryStringReversed.length(); i++) {
            result += Long.parseLong(String.valueOf(binaryStringReversed.charAt(i))) * Math.pow(2, i);
        }
        return result;

    }


    public static void main(String[] args) throws IOException {

        int q = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int qItr = 0; qItr < q; qItr++) {
            long n = scanner.nextLong();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            long result = flippingBits(n);
            System.out.println("result = " + result);

        }


        scanner.close();
    }
}
