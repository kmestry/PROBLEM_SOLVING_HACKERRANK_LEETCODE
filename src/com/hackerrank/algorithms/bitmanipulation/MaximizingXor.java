package com.hackerrank.algorithms.bitmanipulation;

import java.io.IOException;
import java.util.Scanner;

public class MaximizingXor {

    private static final Scanner scanner = new Scanner(System.in);

    // Complete the maximizingXor function below.
    static int maximizingXor(int l, int r) {

        int maximumXor = 0;

        for (int i = l; i <= r; i++) {
            for (int j = i + 1; j <= r; j++) {
                int value = (i | j) - (i & j); //this or that but not both
                if (value > maximumXor)
                    maximumXor = value;

            }
        }

        return maximumXor;

    }

    public static void main(String[] args) throws IOException {

        int l = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int r = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int result = maximizingXor(l, r);

        System.out.println("result = " + result);

        scanner.close();
    }
}
