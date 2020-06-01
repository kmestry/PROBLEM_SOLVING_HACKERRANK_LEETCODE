package com.hackerrank.arrays;

import java.util.Scanner;

public class ArrayManipulation {
    private static final Scanner scanner = new Scanner(System.in);

    // Complete the arrayManipulation function below.
    static long arrayManipulation(int n, int[][] queries) {
        long[] array = new long[n + 1];
        long[] rowArray = new long[3];
        int innerRowCounter = 0;
        long maxSumResult = 0;
        for (int i = 0; i < queries.length; i++) {
            for (int j = 0; j < 3; j++) {

                rowArray[innerRowCounter] = queries[i][j];
                innerRowCounter++;

            }
            updateArray(rowArray, array);
            for (int j = 0; j < array.length; j++) {
                System.out.print(array[j] + " ");
            }
            System.out.println();
            innerRowCounter = 0;
        }
        for (int i = 1; i < array.length; i++) {
            if (array[i] > maxSumResult) {
                maxSumResult = array[i];
            }
        }

        System.out.println("maxSumResult = " + maxSumResult);
        return maxSumResult;
    }

    static long[] updateArray(long[] rowArray, long[] arrayToUpdate) {
        long sumToAdd = rowArray[2];
        for (long i = rowArray[0]; i <= rowArray[1]; i++) {
            arrayToUpdate[(int) i] += sumToAdd;
        }
        for (int i = 0; i < rowArray.length; i++) {
            rowArray[i] = 0;
        }
        return arrayToUpdate;
    }

    /*
     1 2 100
     2 5 100
     3 4 100
     4 5 20
     1 2 50
     */
    public static void main(String[] args) {
        String[] nm = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nm[0]);

        int m = Integer.parseInt(nm[1]);

        int[][] queries = new int[m][3];

        for (int i = 0; i < m; i++) {
            String[] queriesRowItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int j = 0; j < 3; j++) {
                int queriesItem = Integer.parseInt(queriesRowItems[j]);
                queries[i][j] = queriesItem;
            }
        }

        long result = arrayManipulation(n, queries);

    }
}
