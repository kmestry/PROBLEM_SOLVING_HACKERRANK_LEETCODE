package com.hackerrank.arrays;

import java.io.IOException;
import java.util.Scanner;

public class SparseArrays {

    private static final Scanner scanner = new Scanner(System.in);

    // Complete the matchingStrings function below.
    //aba,baba,aba,xzxb
    //aba,xzxb,ab
    static int[] matchingStrings(String[] strings, String[] queries) {
        int[] result = new int[queries.length];
        int counter = 0;
        for (int i = 0; i < queries.length; i++) {
            for (int j = 0; j < strings.length; j++) {
                if (queries[i].equals(strings[j])) {
                    counter++;
                }
            }
            result[i] = counter;
            counter = 0;
        }

        return result;
    }

    public static void main(String[] args) throws IOException {

        int stringsCount = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        String[] strings = new String[stringsCount];

        for (int i = 0; i < stringsCount; i++) {
            String stringsItem = scanner.nextLine();
            strings[i] = stringsItem;
        }

        int queriesCount = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        String[] queries = new String[queriesCount];

        for (int i = 0; i < queriesCount; i++) {
            String queriesItem = scanner.nextLine();
            queries[i] = queriesItem;
        }

        int[] res = matchingStrings(strings, queries);

        scanner.close();
    }
}
