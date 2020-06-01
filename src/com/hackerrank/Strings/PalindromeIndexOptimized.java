package com.hackerrank.Strings;

import java.util.Scanner;

public class PalindromeIndexOptimized {

    // Complete the palindromeIndex function below.
    static int palindromeIndex(String s) {

        if (isPalindrome(s)) {
            return -1;
        }


        StringBuilder stringBuilder = new StringBuilder();
        StringBuilder toTest = new StringBuilder();
        int result = -1;
        int counter = 0;
        for (int i = 0; i < s.length(); i++) {


            if (counter != i) {
                char charToAppend = s.charAt(i);


                toTest = stringBuilder.append(charToAppend);
            }
            if (toTest.length() == s.length() - 1) {
                if (isPalindrome(toTest.toString())) {

                    return counter;

                }
                counter++;
                i = -1;
                toTest.setLength(0);
            }

        }
        return 0;
    }

    static boolean isPalindrome(String inputString) {
        StringBuilder stringBuilder = new StringBuilder(inputString);
        return inputString.equalsIgnoreCase(String.valueOf(stringBuilder.reverse()));
    }

    public static void main(String[] args) {
        // palindromeIndex("baaa");
        //   int result = palindromeIndex("iynilxchelphhsjiftgmbtaxlnbrbhsrptfxfddmhoerxaaaaxreohmddfxftprshbrbnlxatbmgtfishhplehcxlinyi");
        //    System.out.println(result);
       /* Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        int result = palindromeIndex(input);


        System.out.println(result);*/

        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        int result = palindromeIndex(input);


        System.out.println(result);
    }
}
