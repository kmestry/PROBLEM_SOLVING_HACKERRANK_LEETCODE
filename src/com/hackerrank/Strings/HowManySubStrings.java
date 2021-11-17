package com.hackerrank.Strings;

import java.io.IOException;
import java.util.*;

public class HowManySubStrings {

    private static final Scanner scanner = new Scanner(System.in);

    /*
     * Complete the countSubstrings function below.
     */
    static int[] countSubstrings(String s, int[][] queries) {
        long lengthOfString = s.length();
        int[] leftRightIndex = new int[2];
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < lengthOfString; i++) {
            for (int j = 0; j < 2; j++) {
                leftRightIndex[j] = queries[i][j];
            }
            int sizeOfHashSet = (int) findNumberOfDistinctSubString(s, leftRightIndex);
            result.add(sizeOfHashSet);
            System.out.println("sizeOfHashSet = " + sizeOfHashSet);
        }


        return result.stream().mapToInt(value -> value).toArray();
    }

    //aabaa
    static long findNumberOfDistinctSubString(String inputString, int[] leftRightIndex) {

        Set<String> stringSet = new HashSet<>();
        String subjectString = inputString.substring(leftRightIndex[0], leftRightIndex[1] + 1);
        String[] subStringArray = subjectString.split("");
        for (int i = 0; i < subStringArray.length; i++) {
            stringSet.add(subStringArray[i]);
        }
        int incrementCounter = 1;
        while (incrementCounter < subStringArray.length) {
            for (int i = 0; i < subStringArray.length; i++) {
                if (i + incrementCounter + 1 <= subStringArray.length) {
                    String innerSubString = subjectString.substring(i, i + incrementCounter + 1);
                    stringSet.add(innerSubString);
                }
            }
            incrementCounter++;


        }

        return stringSet.size();

    }

    public static void main(String[] args) throws IOException {

        String[] nq = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nq[0].trim());

        int q = Integer.parseInt(nq[1].trim());

        String s = scanner.nextLine();

        int[][] queries = new int[q][2];

        for (int queriesRowItr = 0; queriesRowItr < q; queriesRowItr++) {
            String[] queriesRowItems = scanner.nextLine().split(" ");

            for (int queriesColumnItr = 0; queriesColumnItr < 2; queriesColumnItr++) {
                int queriesItem = Integer.parseInt(queriesRowItems[queriesColumnItr].trim());
                queries[queriesRowItr][queriesColumnItr] = queriesItem;
            }
        }

        int[] result = countSubstrings(s, queries);

        for (int resultItr = 0; resultItr < result.length; resultItr++) {
            System.out.print(result[resultItr]);

            if (resultItr != result.length - 1) {
                System.out.print("\n");
            }
        }

        // findNumberOfDistinctSubString("aabaa", new int[]{1, 4});


    }
}
