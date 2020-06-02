package com.hackerrank.algorithms.implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

public class BirthdayChocolate {

    // Complete the birthday function below.

    /*  5
      1 2 1 3 2
      3 2       */
    static int birthday(List<Integer> s, int d, int m) {
        int sum = d;
        int windowSize = m;
        int resultCounter = 0;

        if (windowSize == 1) {
            return s.get(0) == sum ? 1 : 0;
        }

        for (int i = 0; i < s.size(); i++) {
            if (windowSize > s.size()) {
                break;
            }
            // int sumToCompare = s.get(i) + s.get(windowSize - 1);
            int sumToCompare = 0;
            for (int j = i; j < windowSize; j++) {
                sumToCompare += s.get(j);
            }
            if (sumToCompare == sum) {
                resultCounter++;
            }
            windowSize = windowSize + 1;
        }
        return resultCounter;

    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> s = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        String[] dm = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int d = Integer.parseInt(dm[0]);

        int m = Integer.parseInt(dm[1]);

        int result = birthday(s, d, m);

        System.out.println("result = " + result);

        bufferedReader.close();
    }
}
