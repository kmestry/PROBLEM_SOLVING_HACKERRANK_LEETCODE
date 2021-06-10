package com.hackerrank.interview_companies_1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AnagramDifference {

    public static final int INT = 128;

    public static void main(String[] args) {

        List<Integer> res = AnagramDifference.getMinimumDifference(Arrays.asList("abc"), Arrays.asList("def"));

        System.out.println(res);
    }

    //1 , -1,
    // tea , toe
    //char[] keep count tea,
    // char[] keep count of toe
    public static List<Integer> getMinimumDifference(List<String> a, List<String> b) {
        // Write your code here
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < a.size(); i++) {
            String aString = a.get(i);
            String bString = b.get(i);
            if (aString.length() != bString.length()) {
                result.add(-1);
            } else {
                if (isAnagram(aString, bString)) {
                    result.add(0); //both strings are anagram
                } else {
                    //find minimum difference to make anagram
                    int minDiff = getMinDiff(aString, bString);

                    result.add(minDiff);
                }

            }
        }
        return result;
    }

    private static int getMinDiff(String aString, String bString) {
        char[] aChars = new char[INT];
        char[] bChars = new char[INT];

        for (int j = 0; j < aString.length(); j++) {
            aChars[aString.charAt(j)]++;
        }

        for (int j = 0; j < bString.length(); j++) {
            bChars[bString.charAt(j)]++;
        }

        int count = 0;
        for (int j = 0; j < INT; j++) {
            int aCount = aChars[j];
            int bCount = bChars[j];

            if (aCount != bCount) {
                count += Math.abs(aCount - bCount);
            }
        }

        int minDiff = count / 2;
        return minDiff;
    }

    //
    private static char[] getCharArrayOfLetterCount(String aString, String bString) {
        char[] chars = new char[INT];

        for (int j = 0; j < aString.length(); j++) {
            chars[aString.charAt(j)]++;
        }
        for (int j = 0; j < bString.length(); j++) {
            chars[bString.charAt(j)]--;
        }
        return chars;
    }

    private static boolean isAnagram(String s1, String s2) {
        char[] chars = getCharArrayOfLetterCount(s1, s2);

        for (int i = 0; i < chars.length; i++) {
            if (chars[i] != 0) {
                return false;
            }

        }

        return true;
    }
}
