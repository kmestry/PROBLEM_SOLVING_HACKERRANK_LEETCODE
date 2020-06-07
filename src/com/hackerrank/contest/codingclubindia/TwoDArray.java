package com.hackerrank.contest.codingclubindia;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class TwoDArray {


    static int sumOfArray = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] nq = br.readLine().trim().split(" ");
        int arraySize = Integer.parseInt(nq[0]);
        int numberOfQueries = Integer.parseInt(nq[1]);
        int[][] array = new int[arraySize][arraySize];
        for (int i = 0; i < numberOfQueries; i++) {
            String[] query = br.readLine().trim().split(" ");
            int[] queryArray = new int[query.length];
            for (int j = 0; j < query.length; j++) {
                queryArray[j] = Integer.parseInt(query[j]);
            }
            arrayManipulation(queryArray, array);

        }
    }

    static void arrayManipulation(int[] query, int[][] array) {

        if (query.length == 2) {
            int row = query[1] - 1;
            for (int j = 0; j < array.length; j++) {
                array[row][j] = array[row][j] ^ 1;
                if (array[row][j] == 1) {
                    sumOfArray += 1;
                } else {
                    sumOfArray -= 1;
                }

            }
        } else if (query.length == 3) {
            //reduce 1 index array to 0 index
            int row = query[1] - 1;
            int col = query[2] - 1;
            array[row][col] = array[row][col] ^ 1;
            if (array[row][col] == 1) {
                sumOfArray += array[row][col];
            } else {
                sumOfArray -= 1;
            }

        } else {
            System.out.println((sumOfArray));
        }

    }


}
