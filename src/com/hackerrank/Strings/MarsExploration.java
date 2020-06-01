package com.hackerrank.Strings;

import java.io.IOException;
import java.util.Scanner;

public class MarsExploration {

    private static final Scanner scanner = new Scanner(System.in);

    // Complete the marsExploration function below.
    // SOSSPSSQSSOR
    static int marsExploration(String s) {
        String[] stringArray = s.split("");
        String prefix = "S";
        String middle = "O";
        String suffix = "S";
        int result = 0;
        for (int i = 0; i < stringArray.length; i++) {

            if (!prefix.equals(stringArray[i])) {
                result++;
            }
            if (!middle.equals(stringArray[i + 1])) {
                result++;
            }
            if (!suffix.equals(stringArray[i + 2])) {
                result++;
            }

            i = i + 2;
        }
        return result;


    }

    public static void main(String[] args) throws IOException {

        String s = scanner.nextLine();

        int result = marsExploration(s);

        System.out.println("result = " + result);
    }
}
