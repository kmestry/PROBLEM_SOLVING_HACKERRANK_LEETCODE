package com.leetcode;

import java.util.Arrays;

public class FindTheDifference {

    public static void main(String[] args) {
        char res = new FindTheDifference().findTheDifference("abcd", "abcde");
        System.out.println("res = " + res);
    }

    public char findTheDifference(String s, String t) {

        char[] sChars = s.toCharArray();
        char[] tChars = t.toCharArray();

        Arrays.sort(sChars);
        Arrays.sort(tChars);

        int sPointer = 0;
        int tPointer = 0;

        char result = 0;

        while (sPointer < sChars.length || tPointer < tChars.length) {
            char firstString;
            char secondString;

            if (sPointer >= sChars.length) {
                firstString = '0';
            } else {
                firstString = sChars[sPointer];
            }

            if (tPointer >= tChars.length) {
                secondString = '0';
            } else {
                secondString = tChars[tPointer];
            }

            if (firstString != secondString) {
                result = tChars[tPointer];
                break;
            }

            sPointer++;
            tPointer++;
        }

        return result;
    }

}
