package com.hackerrank.algorithms.implementation;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class EqualizeTheArray {

    private static final Scanner scanner = new Scanner(System.in);

    // Complete the equalizeArray function below.
    static int equalizeArray(int[] arr) {
        Map<Integer, Integer> arrMap = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            if (arrMap.containsKey(arr[i])) {
                int numberOfOccurrence = arrMap.get(arr[i]);
                arrMap.put(arr[i], numberOfOccurrence + 1);
            } else {
                arrMap.put(arr[i], 1);
            }
        }


        int maxOccurrence = arrMap.values().stream().max(Integer::compareTo).get();

        return arr.length - maxOccurrence;

        /*int numberOfTimesMaxValueInMap = (int) arrMap.values().stream().filter(integer -> integer == maxOccurrence).count();

        if (maxOccurrence == 1) {
            return arr.length - 1;
        }
        if (numberOfTimesMaxValueInMap > 1) {
            return arrMap.values().stream().filter(integer -> integer != maxOccurrence).mapToInt(value -> value).sum() + (maxOccurrence * (numberOfTimesMaxValueInMap - 1));
        }

        return arrMap.values().stream().filter(integer -> integer != maxOccurrence).mapToInt(value -> value).sum();
*/

    }

    public static void main(String[] args) throws IOException {

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] arr = new int[n];

        String[] arrItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int arrItem = Integer.parseInt(arrItems[i]);
            arr[i] = arrItem;
        }

        int result = equalizeArray(arr);

        System.out.println("result = " + result);

        scanner.close();
    }
}
