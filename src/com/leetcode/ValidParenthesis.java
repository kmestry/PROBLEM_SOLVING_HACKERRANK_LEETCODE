package com.leetcode;

import java.util.Stack;

public class ValidParenthesis {

    public static void main(String[] args) {
        //   ([)]

        new ValidParenthesis().isValidOptimized("(])}");
    }

    public boolean isValid(String s) {


        Stack<Character> characterStack = new Stack<>();
        boolean isVisited = false;
        for (int i = 0; i < s.length(); i++) {

            char character = s.charAt(i);

            if (character == '{' || character == '[' || character == '(') {
                isVisited = true;
                characterStack.push(character);
            } else if (character == '}' && !characterStack.isEmpty() && characterStack.peek() == '{') {
                isVisited = popStack(characterStack);
            } else if (character == ')' && !characterStack.isEmpty() && characterStack.peek() == '(') {
                isVisited = popStack(characterStack);
            } else if (character == ']' && !characterStack.isEmpty() && characterStack.peek() == '[') {
                isVisited = popStack(characterStack);
            }

            if (!isVisited) {
                characterStack.push(character);
            }

            isVisited = false;

        }

        return characterStack.isEmpty();


    }

    private boolean popStack(Stack<Character> characterStack) {
        characterStack.pop();
        return true;
    }

    public boolean isValidOptimized(String s) {

        if (s.length() % 2 != 0) return false; //odd string will not have proper pair of opening and closing braces.

        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (c == '{' || c == '(' || c == '[') {
                stack.push(c);
            } else {
                if (!stack.isEmpty()) {
                    boolean isVisited = false;
                    if (c == ')' && stack.peek() == '(') {
                        isVisited = isVisited(stack);
                    }
                    if (c == ']' && stack.peek() == '[') {
                        isVisited = isVisited(stack);
                    }
                    if (c == '}' && stack.peek() == '{') {
                        isVisited = isVisited(stack);
                    }
                    if (!isVisited) {
                        return false;

                    }
                }
            }
        }

        return stack.isEmpty();
    }

    private boolean isVisited(Stack<Character> stack) {
        stack.pop();
        return true;
    }
}
