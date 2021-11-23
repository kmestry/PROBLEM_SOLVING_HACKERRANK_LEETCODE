package com.datastructure_studyplan_leetcode;

import java.util.Set;
import java.util.Stack;

public class ValidParenthesis {

    public boolean isValid(String s) {
        Set<Character> openBraces = Set.of('(', '{', '[');
        Set<Character> closedBraces = Set.of(')', '}', ']');

        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (openBraces.contains(c)) {
                stack.push(c);
            } else if (!stack.isEmpty()) {
                char cPeek = stack.peek();
                if (c == ')' && cPeek != '(') {
                    return false;
                } else if (c == '}' && cPeek != '{') {
                    return false;
                } else if (c == ']' && cPeek != '[') {
                    return false;
                }
                stack.pop();
            } else {
                stack.push(c);
            }
        }

        return stack.size() == 0;

    }
}
