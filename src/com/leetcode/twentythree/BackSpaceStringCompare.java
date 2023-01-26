package com.leetcode.twentythree;

import java.util.Stack;

public class BackSpaceStringCompare {

    public static void main(String[] args) {
        BackSpaceStringCompare backSpaceStringCompare = new BackSpaceStringCompare();
        //"ab#c", t = "ad#c"
        backSpaceStringCompare.backspaceCompare("ab#c", "ad#c");
    }

    private static void createStack(String s, Stack<Character> stackS, int i) {
        char c = s.charAt(i);

        if (c != '#') {
            stackS.push(c);
        } else if (!stackS.isEmpty()) {
            stackS.pop();
        }
    }

    public boolean backspaceCompare(String s, String t) {

        Stack<Character> stackS = new Stack<>();
        Stack<Character> stackT = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            createStack(s, stackS, i);
        }
        for (int i = 0; i < t.length(); i++) {
            createStack(t, stackT, i);
        }
        return stackS.equals(stackT);
    }
}
