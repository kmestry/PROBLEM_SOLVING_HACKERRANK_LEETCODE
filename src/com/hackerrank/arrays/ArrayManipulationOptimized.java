package com.hackerrank.arrays;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ArrayManipulationOptimized {
    private static final Scanner scanner = new Scanner(System.in);

    // Complete the arrayManipulation function below.
    static long arrayManipulation(int n, int[][] queries) {
        long[] array = new long[n + 2];

        List<Integer> rowArray = new ArrayList<>();
        Long maxSumResult = Long.valueOf(0);
        long sum = 0;
        for (int i = 0; i < queries.length; i++) {
            for (int j = 0; j < 3; j++) {

                rowArray.add(queries[i][j]);

            }
            updateArray(rowArray, array);
            for (int j = 0; j < array.length; j++) {
                System.out.print(array[j] + " ");
            }
            System.out.println();
        }


        for (int i = 0; i < array.length; i++) {

            sum += array[i];
            if (sum > maxSumResult) {
                maxSumResult = sum;
            }
        }
        System.out.println("maxSumResult = " + maxSumResult);
        return maxSumResult;
    }

    static long[] updateArray(List<Integer> rowArray, long[] arrayToUpdate) {
        long sumToAdd = rowArray.get(2);
        /*for (long i = rowArray.get(0); i <= rowArray.get(1); i++) {
            arrayToUpdate[(int) i] += sumToAdd;
        }*/
        long x = arrayToUpdate[rowArray.get(0)];
        long y = arrayToUpdate[rowArray.get(1)];

        arrayToUpdate[rowArray.get(0)] += sumToAdd;
        arrayToUpdate[rowArray.get(1) + 1] -= sumToAdd;
        rowArray.removeAll(rowArray);
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
