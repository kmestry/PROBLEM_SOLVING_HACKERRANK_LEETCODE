package com.leetcode;

public class StringToLowerCase {

    public static void main(String[] args) {
        new StringToLowerCase().toLowerCase("HELLO");
    }

    public String toLowerCase(String str) {

        StringBuilder lowerCase = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            int value = c;
            int c1 = (value | 32);
            lowerCase.append((char) c1);
        }

        return lowerCase.toString();
    }
}
