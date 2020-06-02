package com.hackerrank.algorithms.implementation;

import java.io.IOException;
import java.util.Scanner;

public class Kangaroo {

    private static final Scanner scanner = new Scanner(System.in);

    // Complete the kangaroo function below.
    static String kangaroo(int x1, int v1, int x2, int v2) {

        if (x1 == x2)
            return "YES";
        int sumOfKangaroo1 = x1 + v1;
        int sumOfKangaroo2 = x2 + v2;

        int x = 0;
        while (x < 10000) {
            if (sumOfKangaroo1 == sumOfKangaroo2) {
                return "YES";
            }
            sumOfKangaroo1 += v1;
            sumOfKangaroo2 += v2;
            x++;
        }
        return "NO";

    }

    public static void main(String[] args) throws IOException {

        String[] x1V1X2V2 = scanner.nextLine().split(" ");

        int x1 = Integer.parseInt(x1V1X2V2[0]);

        int v1 = Integer.parseInt(x1V1X2V2[1]);

        int x2 = Integer.parseInt(x1V1X2V2[2]);

        int v2 = Integer.parseInt(x1V1X2V2[3]);

        String result = kangaroo(x1, v1, x2, v2);
        System.out.println("result = " + result);


        scanner.close();
    }
}
