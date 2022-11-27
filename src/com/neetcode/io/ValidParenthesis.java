package com.neetcode.io;

import java.util.Stack;

public class ValidParenthesis {
    public boolean isValid(String s) {

        Stack<Character> stk = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            //if stk is empty and character is closed character we need to push it to stack.
            if (c == '(' || c == '{' || c == '[' || stk.isEmpty()) {
                stk.push(c);
            } else {
                if (c == ')' && stk.peek() == '(') {
                    stk.pop();
                } else if (c == ']' && stk.peek() == '[') {
                    stk.pop();
                } else if (c == '}' && stk.peek() == '{') {
                    stk.pop();
                } else {
                    return false;
                }
            }
        }

        return stk.isEmpty(); // if its valid parenthesis, there should be no characters left in stack.
    }

}
