package com.leetcode;

import java.util.Stack;


public class BackSpaceStringCompareStackApproach {

    public static void main(String[] args) {
        boolean result = new BackSpaceStringCompareStackApproach().backspaceCompare("a##c", "#a#c");
        System.out.println("result = " + result);
    }

    public boolean backspaceCompare(String S, String T) {

        String s1 = buildString(new Stack<Character>(), S);
        String s2 = buildString(new Stack<Character>(), T);

        return s1.equals(s2);

    }

    private String buildString(Stack<Character> stack, String s) {

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c != '#') {
                stack.push(c);
            } else if (!stack.isEmpty()) {
                stack.pop();
            }
        }

        StringBuilder leftOverString = new StringBuilder();

        while (!stack.isEmpty()) {
            leftOverString.append(stack.pop());
        }
        return leftOverString.toString();
    }
}
