package com.hackerrank.thirtydaysofcode;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class RunningTimeAndComplexity {

    public static final String NOT_PRIME = "Not prime";
    public static final String PRIME = "Prime";


    public static void main(String[] args) throws IOException {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        InputStream in;
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String numberOfTestCases = bufferedReader.readLine().trim();
        long numberOfTestCasesInLong = Long.valueOf(numberOfTestCases);

        for (int i = 0; i < numberOfTestCasesInLong; i++) {
            String numberToTestIfPrimeOrNot = bufferedReader.readLine().trim();
            String result = checkIfPrimeOrNot(Long.parseLong(numberToTestIfPrimeOrNot));
            System.out.println(result);

        }


    }

    static String checkIfPrimeOrNot(long numberToTest) {
        if (numberToTest == 1) {
            return NOT_PRIME;
        }
        if (numberToTest == 2) {
            return PRIME;
        }
        if (numberToTest % 2 == 0) {
            return NOT_PRIME;
        }


        for (long i = 3; i <= Math.sqrt(numberToTest); i = i + 2) {
            if (numberToTest % i == 0) {
                return NOT_PRIME;
            }
        }

        return PRIME;

    }
}