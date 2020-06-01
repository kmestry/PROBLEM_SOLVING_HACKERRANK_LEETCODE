package com.hackerrank.thirtydaysofcode;

import java.util.Scanner;

public class StringDay6 {

    static void printStringOddEvenChars(String inputString) {

        String evenString = "";
        String oddString = " ";
        String[] inputArray = inputString.split("");
        for (int i = 0; i < inputArray.length; i++) {
            if (i % 2 == 0) {
                evenString += inputArray[i];
            } else {
                oddString += inputArray[i];
            }
        }
        System.out.println(evenString + oddString);


    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        String inputString = "";
        String[] inputArray = new String[n];
        for (int i = 0; i < n; i++) {
            String value = scanner.next();
            inputArray[i] = value;
        }
        for (int i = 0; i < inputArray.length; i++) {
            printStringOddEvenChars(inputArray[i]);

        }

    }
}
