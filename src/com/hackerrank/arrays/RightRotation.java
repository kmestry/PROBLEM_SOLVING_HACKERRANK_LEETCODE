package com.hackerrank.arrays;

import java.util.Scanner;

public class RightRotation {

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

        int[] b = new int[n];
        for (int i = 0; i < n - d; i++) {
            int temp = a[n - 1];
            for (int j = 0; j < a.length; j++) {

                int currentValue = a[j];
                if (j + 1 >= a.length)
                    b[0] = temp;
                else
                    b[j + 1] = currentValue;
            }


        }
        for (int i = 0; i < b.length; i++) {
            System.out.print(b[i] + " ");
        }

    }
}
