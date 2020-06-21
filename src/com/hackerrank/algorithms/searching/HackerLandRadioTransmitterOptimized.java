package com.hackerrank.algorithms.searching;

import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class HackerLandRadioTransmitterOptimized {

    private static final Scanner scanner = new Scanner(System.in);

    // Complete the hackerlandRadioTransmitters function below.
    static int hackerlandRadioTransmitters(int[] x, int k) {
        Arrays.sort(x);
        int numOfTransmitters = 0;
        int initiali = 0;
        while (initiali < x.length) {
            numOfTransmitters++;
            int loc = x[initiali] + k;
            while (initiali < x.length && x[initiali] <= loc) {
                initiali++;
            }
            loc = x[--initiali] + k;
            while (initiali < x.length && x[initiali] <= loc) {
                initiali++;
            }
        }
        //System.out.println(numOfTransmitters);
        return numOfTransmitters;
    }

    public static void main(String[] args) throws IOException {

        String[] nk = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nk[0]);

        int k = Integer.parseInt(nk[1]);

        int[] x = new int[n];

        String[] xItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int xItem = Integer.parseInt(xItems[i]);
            x[i] = xItem;
        }

        int result = hackerlandRadioTransmitters(x, k);
        System.out.println("result = " + result);

       /* int index = binarySearch(new int[]{2, 4, 5, 6, 7, 9, 11, 12}, 20);
        System.out.println("index = " + index);*/


        scanner.close();
    }
}
