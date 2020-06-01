package com.hackerrank.Strings;

import java.util.Scanner;

public class PalindromeIndex {
    // Complete the palindromeIndex function below.
    static int palindromeIndex(String s) {

        if (isPalindrome(s)) {
            return -1;
        }


        StringBuilder stringBuilder = new StringBuilder();
        StringBuilder toTest = null;
        int result = -1;
        for (int i = 0; i < s.length(); i++) {

            for (int j = 0; j < s.length(); j++) {
                if (j != i) {
                    char charToAppend = s.charAt(j);

                    toTest = stringBuilder.append(charToAppend);
                }

            }
            if (isPalindrome(toTest.toString())) {

                return i;
            }
            toTest.setLength(0);
        }


        return -1;
    }

    static boolean isPalindrome(String inputString) {
        StringBuilder stringBuilder = new StringBuilder(inputString);
        return inputString.equalsIgnoreCase(String.valueOf(stringBuilder.reverse()));
    }

    public static void main(String[] args) {
        // palindromeIndex("baaa");
        // int result = palindromeIndex("wykkttfghdvbyxbxefnltpnbdkkdbnptlnfexbxybvdhgfttkkyw");

        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        int result = palindromeIndex(input);


        System.out.println(result);
    }
}
