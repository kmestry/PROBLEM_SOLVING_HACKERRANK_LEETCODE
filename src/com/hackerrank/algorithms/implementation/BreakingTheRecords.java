package com.hackerrank.algorithms.implementation;

import java.io.IOException;
import java.util.Scanner;

public class BreakingTheRecords {

    private static final Scanner scanner = new Scanner(System.in);


    //        10 5 20 20 4 5 2 25 1
    // Complete the breakingRecords function below.
    static int[] breakingRecords(int[] scores) {
        int highestCounter = 0;
        int lowestCounter = 0;
        int highestScore = scores[0];
        int lowestScore = scores[0];
        int[] result = new int[2];

        for (int i = 1; i < scores.length; i++) {
            if (scores[i] > highestScore) {
                highestScore = scores[i];
                highestCounter++;
            } else if (scores[i] < lowestScore) {
                lowestScore = scores[i];
                lowestCounter++;
            }
        }

        result[0] = highestCounter;
        result[1] = lowestCounter;

        return result;
    }

    public static void main(String[] args) throws IOException {

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] scores = new int[n];

        String[] scoresItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int scoresItem = Integer.parseInt(scoresItems[i]);
            scores[i] = scoresItem;
        }

        int[] result = breakingRecords(scores);

        for (int i = 0; i < result.length; i++) {
            System.out.print(result[i] + " ");
        }


        scanner.close();
    }
}
