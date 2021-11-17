package com.hackerrank.hackerfest.october10;

import java.io.*;
import java.util.List;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

public class GameOfMaximization {
    /*
     * Complete the 'maximumStones' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts INTEGER_ARRAY arr as parameter.
     */

    // https://www.hackerrank.com/contests/hackerrank-hackfest-2020/challenges/stones-piles/problem

    public static int maximumStones(List<Integer> arr) {
        // Write your code here
        int oddSum = 0;
        int evenSum = 0;


        for (int i = 0; i < arr.size(); i++) {
            int element = arr.get(i);
            if (i % 2 == 0) {
                oddSum += element;
            } else {
                evenSum += element;
            }
        }

        int minSum = Math.min(oddSum, evenSum);

        return minSum * 2;

    }


    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        int result = GameOfMaximization.maximumStones(arr);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();

    }
}