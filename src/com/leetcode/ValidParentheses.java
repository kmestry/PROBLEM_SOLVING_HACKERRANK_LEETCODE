package com.leetcode;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

public class ValidParentheses {

    public boolean isValid(String s) {
        Set<Character> openChars = new HashSet<>();
        openChars.add('{');
        openChars.add('[');
        openChars.add('(');
        Set<Character> closedChars = new HashSet<>();
        closedChars.add('}');
        closedChars.add(']');
        closedChars.add(')');

        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (stack.isEmpty()) {
                stack.push(c);
            } else if (closedChars.contains(c)) {

                if (c == '}' && stack.peek() == '{') {
                    stack.pop();
                } else if (c == ']' && stack.peek() == '[') {
                    stack.pop();
                } else if (c == ')' && stack.peek() == '(') {
                    stack.pop();
                } else {
                    return false;
                }
            } else {
                stack.push(c);
            }

        }

        return stack.isEmpty();
    }
}
