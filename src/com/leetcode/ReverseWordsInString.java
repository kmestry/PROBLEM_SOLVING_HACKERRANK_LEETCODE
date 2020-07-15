package com.leetcode;

import java.util.Stack;

public class ReverseWordsInString {

    public static void main(String[] args) {
        String result = reverseWordsOptimized("a good   example");
        System.out.println("result = " + result);
    }

    public static String reverseWords(String s) {
        String result = "";
        String[] stringArray = s.split(" ");
        for (int i = stringArray.length - 1; i >= 0; i--) {
            if (!stringArray[i].isEmpty())
                result += stringArray[i] + " ";
        }

        return result.trim();

    }

    public static String reverseWordsOptimized(String s) {
        Stack<String> stringStack = new Stack<>();

        String word = "";
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != ' ') {
                word += s.charAt(i);
            } else {
                if (word.length() > 0) {
                    stringStack.push(word);
                    word = "";
                }
            }

        }

        if (word.length() > 0) {
            stringStack.push(word);
        }

        String result = "";
        while (!stringStack.isEmpty()) {
            if (stringStack.size() != 1) {
                result += stringStack.pop() + " ";
            } else {
                result += stringStack.pop() + "";
            }
        }

        return result;

    }

}
