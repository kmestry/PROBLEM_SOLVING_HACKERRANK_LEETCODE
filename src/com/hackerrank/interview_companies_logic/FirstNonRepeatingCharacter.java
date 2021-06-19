package com.hackerrank.interview_companies_logic;

public class FirstNonRepeatingCharacter {

    //"STreSS"
    public static String firstNonRepeatingLetter(String str) {

        char[] chars = new char[128];
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            char lowerCase = Character.toLowerCase(c);
            chars[lowerCase]++;
        }

        for (int i = 0; i < str.length(); i++) {
            char lowerCase = Character.toLowerCase(str.charAt(i));
            if (chars[lowerCase] == 1) {
                return String.valueOf(str.charAt(i));
            }
        }
        return "";
    }
}
