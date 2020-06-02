package com.hackerrank.algorithms.implementation;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ClimbingTheLadder {

    private static final Scanner scanner = new Scanner(System.in);

    // Complete the climbingLeaderboard function below.
            /*
               7
               100 100 50 40 40 20 10
               4
               5 25 50 120
               */
    static int[] climbingLeaderboard(int[] scores, int[] alice) {
        List<Integer> distinctList;
        int[] result = new int[alice.length];

        distinctList = IntStream.of(scores).boxed().distinct().collect(Collectors.toList());
        List<Integer> linkedScoresList = new LinkedList<>(distinctList);

        for (int i = 0; i < alice.length; i++) {

            for (int j = 0; j < linkedScoresList.size(); j++) {


                if (alice[i] > linkedScoresList.get(j)) {
                    linkedScoresList.add(j, alice[i]);
                    result[i] = j + 1;
                    break;
                } else if (alice[i] == linkedScoresList.get(j)) {
                    linkedScoresList.add(j, linkedScoresList.remove(j));
                    result[i] = j + 1;
                    break;
                } else if (j == linkedScoresList.size() - 1) {
                    linkedScoresList.add(j + 1, alice[i]);
                    result[i] = j + 2;
                    break;
                }


            }
        }
        return result;
    }

    public static void main(String[] args) throws IOException {

        int scoresCount = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] scores = new int[scoresCount];

        String[] scoresItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < scoresCount; i++) {
            int scoresItem = Integer.parseInt(scoresItems[i]);
            scores[i] = scoresItem;
        }

        int aliceCount = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] alice = new int[aliceCount];

        String[] aliceItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < aliceCount; i++) {
            int aliceItem = Integer.parseInt(aliceItems[i]);
            alice[i] = aliceItem;
        }

        int[] result = climbingLeaderboard(scores, alice);
        for (int i = 0; i < result.length; i++) {
            System.out.print(result[i] + " ");
        }


        scanner.close();
    }
}
