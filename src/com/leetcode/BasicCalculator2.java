package com.leetcode;

import java.util.Stack;

public class BasicCalculator2 {

    boolean isAddSub = false;
    boolean isMulDiv = false;
    boolean isSamePriorityOperands = true;

    public static void main(String[] args) {
        int val = new BasicCalculator2().calculate("-2*3+4");
        System.out.println("val = " + val);
    }

    public int calculate(String s) {
        int currNum = 0;
        char ch = '+';
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (Character.isDigit(c)) {
                currNum = currNum * 10 + c - '0';
            } else if (!Character.isDigit(c) && c != ' ') {

                pushToStack(currNum, ch, stack);
                currNum = 0;
                ch = c;

            }
        }

        pushToStack(currNum, ch, stack);

        int result = 0;
        while (!stack.isEmpty()) {
            result += stack.pop();
        }

        return result;
    }

    private void pushToStack(int currNum, char ch, Stack<Integer> stack) {

        if (ch == '+') {
            stack.push(currNum);
        } else if (ch == '-') {
            stack.push(-currNum);
        } else if (ch == '*') {
            stack.push(stack.pop() * currNum);
        } else if (ch == '/') {
            stack.push(stack.pop() / currNum);
        }
    }
}
