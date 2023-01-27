package com.leetcode.twentythree;

import java.util.Stack;

public class DecodeStrings {

    public static void main(String[] args) {
        DecodeStrings decodeStrings = new DecodeStrings();
        decodeStrings.decodeString("3[a]2[bc]");
    }

    public String decodeString(String s) {

        Stack<Integer> intStack = new Stack<>();
        Stack<StringBuilder> strStack = new Stack<>();

        int num = 0;
        StringBuilder curr = new StringBuilder();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (Character.isDigit(c)) {
                num = num * 10 + c - '0';
            } else if (Character.isAlphabetic(c)) {
                curr.append(c);
            } else if (c == '[') {
                intStack.push(num);
                strStack.push(curr);
                num = 0;
                curr = new StringBuilder();
            } else {
                StringBuilder temp = curr;
                int iter = intStack.pop();
                curr = strStack.pop();
                while (iter > 0) {
                    curr.append(temp);
                    iter--;
                }
            }

        }

        return curr.toString();

    }
}
