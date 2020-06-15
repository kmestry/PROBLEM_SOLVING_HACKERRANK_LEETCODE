package com.hackerrank.thirtydaysofcode;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class NestedLogic {

    public static void main(String[] args) throws IOException {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String[] arrayActualReturnDateOfBook = bufferedReader.readLine().trim().split(" ");
        int[] actualReturnDateArray = new int[3];
        int[] expectedReturnDateArray = new int[3];
        for (int i = 0; i < arrayActualReturnDateOfBook.length; i++) {
            actualReturnDateArray[i] = Integer.parseInt(arrayActualReturnDateOfBook[i]);
        }
        String[] arrayExpectedReturnDateOfBook = bufferedReader.readLine().trim().split(" ");
        for (int i = 0; i < arrayExpectedReturnDateOfBook.length; i++) {
            expectedReturnDateArray[i] = Integer.parseInt(arrayExpectedReturnDateOfBook[i]);
        }
        fineInHackos(actualReturnDateArray, expectedReturnDateArray);
    }

    static void fineInHackos(int[] actualArray, int[] expectedArray) {

        int actualYear = actualArray[2];
        int actualMonth = actualArray[1];
        int actualDay = actualArray[0];

        int expectedYear = expectedArray[2];
        int expectedMonth = expectedArray[1];
        int expectedDay = expectedArray[0];

        if (actualYear < expectedYear) {
            System.out.println(0);
            return;
        }

        if (actualYear > expectedYear) {
            System.out.println(10000);
            return;
        }
        if (actualDay <= expectedDay && actualMonth <= expectedMonth) {
            System.out.println(0);
            return;
        }
        if (actualMonth > expectedMonth) {
            System.out.println(500 * (actualMonth - expectedMonth));
            return;
        }
        if (actualDay != expectedDay) {
            System.out.println(15 * (actualDay - expectedDay));
            return;
        }


    }
}