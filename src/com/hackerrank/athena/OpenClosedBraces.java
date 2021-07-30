package com.hackerrank.athena;

import java.util.*;

public class OpenClosedBraces {

    public static final String INVALID_STRING = "NO";
    public static final String VALID_STRING = "YES";
    //['{}[]()', '{[}]}']
    public static final Set<Character> openBraces = new HashSet<>(Arrays.asList('{', '(', '['));
    public static final Set<Character> closedBraces = new HashSet<>(Arrays.asList('}', ')', ']'));

    public static List<String> braces(List<String> values) {
        List<String> result = new ArrayList<>();
        for (String str : values) {
            if (str.length() % 2 != 0) {
                result.add(INVALID_STRING);
            } else {
                result.add(isValidString(str));
            }
        }

        return result;
    }

    private static String isValidString(String str) {

        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);

            if (openBraces.contains(c) || stack.isEmpty()) {
                stack.push(c);
            } else if (closedBraces.contains(c)) {
                char peekChar = stack.peek();
                if (peekChar == '{' && c == '}') {
                    stack.pop();
                } else if (peekChar == '[' && c == ']') {
                    stack.pop();
                } else if (peekChar == '(' && c == ')') {
                    stack.pop();
                } else {
                    return INVALID_STRING;
                }
            }
        }
        return stack.size() == 0 ? VALID_STRING : INVALID_STRING;

    }

}
