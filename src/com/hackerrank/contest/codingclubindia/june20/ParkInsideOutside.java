package com.hackerrank.contest.codingclubindia.june20;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ParkInsideOutside {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String numberOfTestCases = bufferedReader.readLine();

        for (int i = 0; i < Long.parseLong(numberOfTestCases); i++) {
            String[] inputArray = bufferedReader.readLine().split(" ");
            printResults(inputArray);
        }
    }

    static void printResults(String[] array) {
        long x1 = Long.parseLong(array[0]);
        long y1 = Long.parseLong(array[1]);
        long x2 = Long.parseLong(array[2]);
        long y2 = Long.parseLong(array[3]);
        long x3 = Long.parseLong(array[4]);
        long y3 = Long.parseLong(array[5]);

        if (x3 > x1 && x3 < x2 && y3 > y1 && y3 < y2) {
            System.out.println("INSIDE");
        } else {
            System.out.println("NOT INSIDE");
        }
    }
}
