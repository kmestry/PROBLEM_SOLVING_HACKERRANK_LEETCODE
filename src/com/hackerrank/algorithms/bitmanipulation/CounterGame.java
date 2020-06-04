package com.hackerrank.algorithms.bitmanipulation;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CounterGame {

    private static final Scanner scanner = new Scanner(System.in);

    // Complete the counterGame function below.
    static String counterGame(long n) {
        List<Long> listOfPowerOfTwo = new ArrayList<>();
        int countNumberOfOperation = 0;

        while (n > 1) {
            boolean isNumPowerOfTwo = isNumberPowerOfTwo(n);
            if (isNumPowerOfTwo) {
                n = n / 2;

            } else {
                long closestPowerOfTwo = closetPowerOfTwo(n, listOfPowerOfTwo);
                n = n - closestPowerOfTwo;
            }
            countNumberOfOperation++;

        }
        if (countNumberOfOperation % 2 == 0) {
            return "Richard";
        }
        return "Louise";
    }

    private static Long closetPowerOfTwo(long n, List<Long> listOfPowerOfTwo) {
        long i = 2;
        long closestPowerOfTwo = 0;
        listOfPowerOfTwo.add(i);
        while (n > i) {
            i = i * 2;
            listOfPowerOfTwo.add(i);
        }

        for (Long l : listOfPowerOfTwo) {
            if (l < n) {
                closestPowerOfTwo = l;
            }
        }
        return closestPowerOfTwo;
    }

    static boolean isNumberPowerOfTwo(long number) {

        while (number > 1) {
            if (number % 2 != 0)
                return false;
            number = number / 2;
        }
        return true;
    }

    public static void main(String[] args) throws IOException {

        int t = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int tItr = 0; tItr < t; tItr++) {
            long n = scanner.nextLong();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            String result = counterGame(n);

            System.out.println("result = " + result);
        }


        scanner.close();
    }
}

