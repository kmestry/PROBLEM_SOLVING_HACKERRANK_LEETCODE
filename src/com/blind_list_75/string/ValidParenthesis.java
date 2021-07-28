package com.blind_list_75.string;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class ValidParenthesis {

    public static void main(String[] args) {
        ValidParenthesis validParenthesis = new ValidParenthesis();
        validParenthesis.isValid("{[]}");
    }

    public boolean isValid(String s) {

        if (s.length() % 2 != 0) return false;
        Map<Character, Integer> openBrackMap = new HashMap<>();
        Map<Character, Integer> closedBrackMap = new HashMap<>();
        openBrackMap.put('(', 1);
        openBrackMap.put('{', 2);
        openBrackMap.put('[', 3);

        closedBrackMap.put(')', 1);
        closedBrackMap.put('}', 2);
        closedBrackMap.put(']', 3);

        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (openBrackMap.containsKey(c)) {
                stack.push(c);
            } else if (closedBrackMap.containsKey(c)) {

                if (stack.size() == 0 || closedBrackMap.containsKey(stack.peek())) {
                    stack.push(c);
                    continue;
                }
                char cPoped = stack.peek();
                int num = openBrackMap.get(cPoped);
                int currNum = closedBrackMap.get(c);

                if (num != currNum) {
                    return false;
                } else {
                    stack.pop();
                }

            }
        }

        return stack.size() <= 0;
    }
}
