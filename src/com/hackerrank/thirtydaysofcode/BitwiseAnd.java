package com.hackerrank.thirtydaysofcode;

import java.util.Scanner;
import java.util.stream.IntStream;

public class BitwiseAnd {


    private static final Scanner scanner = new Scanner(System.in);

    // 1 2 3 4 5
    public static void main(String[] args) {
        int t = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int tItr = 0; tItr < t; tItr++) {
            String[] nk = scanner.nextLine().split(" ");

            int n = Integer.parseInt(nk[0]);

            int k = Integer.parseInt(nk[1]);

            int[] arrayOfIntegers = IntStream.range(1, n + 1).toArray();

            int result = getBitWiseAndMax(k, arrayOfIntegers);

            System.out.println(result);
        }

        scanner.close();
    }

    private static int getBitWiseAndMax(int k, int[] arrayOfIntegers) {
        int max = 0;
        for (int i = 0; i < arrayOfIntegers.length; i++) {
            for (int j = i + 1; j < arrayOfIntegers.length; j++) {
                int result = arrayOfIntegers[i] & arrayOfIntegers[j];
                if (result < k && result > max) {
                    max = result;
                }

            }
        }
        return max;
    }
}
