package com.hackerrank.contest.codingclubindia.june20;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SquareCheck {


    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String numberOfTestCases = bufferedReader.readLine();

        for (int i = 0; i < Integer.parseInt(numberOfTestCases); i++) {
            String numberOfValidValues = bufferedReader.readLine();
            String[] intValues = bufferedReader.readLine().trim().split(" ");

            printResult(intValues);


        }


    }

    static void printResult(String[] intValues) {


        for (int i = 0; i < intValues.length; i++) {
            if (Long.parseLong(intValues[i]) < 0) {
                System.out.println("No");
                return;
            }
            // square root of x.
            double sr = Math.sqrt(Long.parseLong(intValues[i]));

            // If square root is an integer
            if ((sr - Math.floor(sr)) != 0) {
                System.out.println("No");
                return;
            }

        }

        System.out.println("Yes");
    }
}
