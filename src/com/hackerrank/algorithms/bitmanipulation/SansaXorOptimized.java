package com.hackerrank.algorithms.bitmanipulation;

import java.io.IOException;
import java.util.Scanner;

public class SansaXorOptimized {

    private static final Scanner scanner = new Scanner(System.in);

    // Complete the sansaXor function below.
    // 4 5 6 7
    static int sansaXor(int[] arr) {
        int counter = 0;
        int innerCounter = 0;
        int finalResultXor = 0;

        if (arr.length % 2 == 0)
            return 0;
        for (int i = 0; i < arr.length; i++) {
            if (i % 2 == 0) {
                finalResultXor ^= arr[i];
            }
        }
        return finalResultXor;
    }

    public static void main(String[] args) throws IOException {

        int t = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int tItr = 0; tItr < t; tItr++) {
            int n = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            int[] arr = new int[n];

            String[] arrItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int i = 0; i < n; i++) {
                int arrItem = Integer.parseInt(arrItems[i]);
                arr[i] = arrItem;
            }

            int result = sansaXor(arr);
            System.out.println("result = " + result);

        }


        scanner.close();
    }
}
