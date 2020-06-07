package com.hackerrank.algorithms.bitmanipulation;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SansaXor {

    private static final Scanner scanner = new Scanner(System.in);

    // Complete the sansaXor function below.
    // 4 5 6 7
    static int sansaXor(int[] arr) {
        List<Integer> resultList = new ArrayList<>();
        int counter = 0;
        int innerCounter = 0;
        int finalResultXor = 0;
        while (counter < arr.length) {
            for (int i = 0; i < arr.length; i++) {
                List<Integer> innerList = new ArrayList();
                if (innerCounter > arr.length - 1)
                    break;
                for (int j = i; j <= innerCounter; j++) {
                    innerList.add(arr[j]);
                }
                innerCounter++;
                int resultXor = 0;
                int reducedListUsingXor = 0;
                if (innerList.size() > 1)
                    reducedListUsingXor = innerList.stream().reduce(0, (a, b) -> a ^ b);
                else
                    reducedListUsingXor = innerList.get(0);
                finalResultXor = finalResultXor ^ reducedListUsingXor;
                // resultList.add(reducedListUsingXor);
            }
            counter++;
            innerCounter = counter;
        }

        // int finalResultXor = resultList.stream().reduce(0, (a, b) -> a ^ b);


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
