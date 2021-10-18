package com.leetcode_restart;

import java.util.Set;
import java.util.Stack;

public class ValidParenthesis {

    public boolean isValid(String s) {

        Set<Character> openBrackets = Set.of('(', '{', '[');
        Set<Character> closedBrackets = Set.of(')', '}', ']');

        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (openBrackets.contains(c)) {
                stack.push(c);
            } else if (closedBrackets.contains(c) && !stack.isEmpty()) {
                char cPop = stack.peek();

                if (cPop == '(' && c == ')' || cPop == '{' && c == '}' || cPop == '[' && c == ']') {
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
