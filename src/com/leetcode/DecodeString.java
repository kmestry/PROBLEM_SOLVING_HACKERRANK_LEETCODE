package com.leetcode;

import java.util.Stack;

public class DecodeString {

    public static void main(String[] args) {
        new DecodeString().decodeString("3[a2[c]]");
    }

    //3[a2[c]]
    public String decodeString(String s) {

        String result = "";
        Stack<Integer> countStack = new Stack<>();
        Stack<String> stringStack = new Stack<>();
        int index = 0;

        while (index < s.length()) {

            char c = s.charAt(index);
            if (Character.isDigit(c)) {
                int count = 0;
                //if num is 21
                while (Character.isDigit(s.charAt(index))) {
                    count = count * 10 + (s.charAt(index) - '0');
                    index++;
                }
                countStack.push(count);

            } else if (c == '[') {
                stringStack.push(result);
                result = "";
                index++;
            } else if (c == ']') {
                int repetition = countStack.pop();
                StringBuilder sb = new StringBuilder(stringStack.pop());

                for (int i = 0; i < repetition; i++) {
                    sb.append(result);
                }
                result = sb.toString();
                index++;
            } else {
                result += c;
                index++;

            }

        }
        return result;

    }
}
