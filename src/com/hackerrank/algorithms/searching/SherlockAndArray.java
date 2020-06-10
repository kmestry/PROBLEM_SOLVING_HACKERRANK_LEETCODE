package com.hackerrank.algorithms.searching;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

public class SherlockAndArray {

    // Complete the balancedSums function below.
    //1 1 4 1 1
    static String balancedSums(List<Integer> arr) {

        int leftSum = 0;
        int rightSum = 0;

        for (int i = 0; i < arr.size(); i++) {

            for (int j = i - 1; j >= 0; j--) {
                leftSum += arr.get(j);
            }

            for (int j = i + 1; j < arr.size(); j++) {
                rightSum += arr.get(j);
            }

            if (leftSum == rightSum) {
                return "YES";
            }
            leftSum = 0;
            rightSum = 0;

        }
        return "NO";

    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(bufferedReader.readLine().trim());

        IntStream.range(0, T).forEach(TItr -> {
            try {
                int n = Integer.parseInt(bufferedReader.readLine().trim());

                List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                        .map(Integer::parseInt)
                        .collect(toList());

                String result = balancedSums(arr);
                System.out.println("result = " + result);

            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        bufferedReader.close();
    }
}
