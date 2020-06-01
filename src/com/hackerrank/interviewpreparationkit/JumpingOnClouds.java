package com.hackerrank.interviewpreparationkit;

import java.io.IOException;
import java.util.Scanner;

public class JumpingOnClouds {

    private static final Scanner scanner = new Scanner(System.in);

    // Complete the jumpingOnClouds function below.
    // 0 0 0 0 1 0
    static int jumpingOnClouds(int[] c) {
        int minimumNoOfJumps = 0;

        for (int i = 0; i < c.length; i++) {
            if (i + 1 == c.length - 1) {
                minimumNoOfJumps++;
                break;
            }
            if (i + 2 >= c.length) {
                break;
            }
            if (c[i + 2] == 0) {
                i = i + 1;
            }
            minimumNoOfJumps++;
        }
        System.out.println("minimumNoOfJumps = " + minimumNoOfJumps);
        return minimumNoOfJumps;


    }

    public static void main(String[] args) throws IOException {

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] c = new int[n];

        String[] cItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int cItem = Integer.parseInt(cItems[i]);
            c[i] = cItem;
        }

        int result = jumpingOnClouds(c);


        scanner.close();
    }
}
