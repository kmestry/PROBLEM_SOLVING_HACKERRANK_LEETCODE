package com.hackerrank.algorithms.searching;

import java.io.IOException;
import java.util.Scanner;

public class IceCreamParlour {


    private static final Scanner scanner = new Scanner(System.in);

    // Complete the icecreamParlor function below.
    //4  ==money
    //1 4 5 3 2  == array
    static int[] icecreamParlor(int m, int[] arr) {

        int[] result = new int[2];

        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] + arr[j] == m) {
                    result[0] = i + 1;
                    result[1] = j + 1;
                    break;
                }
            }
        }

        return result;

    }

    public static void main(String[] args) throws IOException {

        int t = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int tItr = 0; tItr < t; tItr++) {
            int m = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            int n = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            int[] arr = new int[n];

            String[] arrItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int i = 0; i < n; i++) {
                int arrItem = Integer.parseInt(arrItems[i]);
                arr[i] = arrItem;
            }

            int[] result = icecreamParlor(m, arr);

            for (int i = 0; i < result.length; i++) {
                System.out.println("result = " + result[i]);

                if (i != result.length - 1) {
                    System.out.print(" ");
                }
            }

        }


        scanner.close();
    }
}

