package com.hackerrank.algorithms.implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class DayOfProgrammer {


    private final static String PROGRAMMER_MONTH = ".09.";
    private final static int sumOfFirstEightMonths = 243;
    private final static int dayOfProgrammer = 256;

    // Complete the dayOfProgrammer function below.
    static String dayOfProgrammer(int year) {
        //Julian calendar leap year.
        if (year == 1918) {
            return "26.09.1918";

        }
        if (year >= 1700 && year <= 1917) {
            if (year % 4 == 0) {
                //leap year.
                return getLeapYearResult(year);

            } else {
                return getNonLeapYearResult(year);
            }


        } else {
            //gregorian calendar
            if (year % 400 == 0) {
                //leap year
                return getLeapYearResult(year);

            } else if (year % 4 == 0 && year % 100 != 0) {
                //leap year
                return getLeapYearResult(year);
            } else {
                //non leap
                return getNonLeapYearResult(year);
            }
        }


    }

    private static String getNonLeapYearResult(int year) {
        int resultDay = dayOfProgrammer - sumOfFirstEightMonths;
        return resultDay + PROGRAMMER_MONTH + year;
    }

    private static String getLeapYearResult(int year) {
        int day = sumOfFirstEightMonths + 1;
        int resultDay = dayOfProgrammer - day;
        return resultDay + PROGRAMMER_MONTH + year;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int year = Integer.parseInt(bufferedReader.readLine().trim());

        String result = dayOfProgrammer(year);

        System.out.println("result = " + result);

        bufferedReader.close();
    }
}

