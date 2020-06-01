package com.hackerrank.Strings;

import java.util.Stack;
import java.util.stream.Stream;

public class SuperReducedStringStack {

    // Complete the superReducedString function below.
    static String superReducedString(String s) {
        Stack<String> stack = new Stack();
        String[] stringArray = s.split("");
        Stream.of(stringArray).forEach(character -> {

            if (!stack.empty() && stack.peek().equals(character)) {
                stack.pop();
            } else {
                stack.push(character);
            }

        });
        StringBuilder result = new StringBuilder();
        stack.stream().forEach(result::append);
        System.out.println(result);

        if (result.length() == 0) {
            return "Empty String";
        } else {
            return result.toString();
        }


    }

    public static void main(String[] args) {

        superReducedString("aaabccddd");
    }
}
