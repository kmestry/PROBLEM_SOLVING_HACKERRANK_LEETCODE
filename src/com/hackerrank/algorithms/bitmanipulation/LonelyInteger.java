package com.hackerrank.algorithms.bitmanipulation;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

public class LonelyInteger {

    private static final Scanner scanner = new Scanner(System.in);

    // Complete the lonelyinteger function below.
    static int lonelyinteger(int[] a) {
  /*      int value = 0;
        for (int i = 0; i < a.length; i++) {
            value=value ^ a[i];

        }

        return value;*/
        Map<Integer, Integer> arrayMap = new HashMap<>();
        for (int i = 0; i < a.length; i++) {
            if (arrayMap.containsKey(a[i])) {
                arrayMap.put(a[i], arrayMap.get(a[i]) + 1);
            } else {
                arrayMap.put(a[i], 1);
            }
        }

        List<Map.Entry<Integer, Integer>> result = arrayMap.entrySet().stream().filter(integerIntegerEntry -> integerIntegerEntry.getValue() == 1).collect(Collectors.toList());

        return result.get(0).getKey();

    }

    public static void main(String[] args) throws IOException {

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] a = new int[n];

        String[] aItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int aItem = Integer.parseInt(aItems[i]);
            a[i] = aItem;
        }

        int result = lonelyinteger(a);


        scanner.close();
    }
}

