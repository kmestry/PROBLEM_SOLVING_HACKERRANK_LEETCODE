package com.hackerrank.arrays;

import java.util.Scanner;

/*
*    5 4
     1 2 3 4 5
*
*
*
*
*
*         14 7

          98 67 35 1 74 79 7 26 54 63 24 17 32 81
          *
          *
          *
          26 54 63 24 17 32 81 98 67 35 1 74 79 7
* */
public class LeftRotation {
    private static final Scanner scanner = new Scanner(System.in);


    public static void main(String[] args) {
        String[] nd = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nd[0]);

        int d = Integer.parseInt(nd[1]);

        int[] a = new int[n];

        String[] aItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int aItem = Integer.parseInt(aItems[i]);
            a[i] = aItem;
        }

        scanner.close();


        //1 2 3 4 5

        for (int i = 0; i < d; i++) {
            int temp = a[0];
            for (int j = 0; j < a.length - 1; j++) {
                a[j] = a[j + 1];

            }
            a[a.length - 1] = temp;

        }
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }

    }
}
