package com.leetcode;

public class ReverseWordsInStringOptimized {

    public static void main(String[] args) {
        String result = reverseWords("  hello world!  ");
        System.out.println("result = " + result);
    }

    public static String reverseWords(String s) {

        String word = "";
        String result = "";
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) != ' ') {
                word = s.charAt(i) + word;
            } else {
                if (word.length() > 0) {
                    result += word + " ";
                    word = "";
                }
            }

        }

        final String s1;
        if (word.length() > 0) s1 = result + word;
        else s1 = result.length() > 0 && result.charAt(result.length() - 1) == ' ' ? createString(result) : result;
        return s1;

    }

    public static String createString(String inputString) {
        return new StringBuilder(inputString).deleteCharAt(inputString.length() - 1).toString();
    }

}
