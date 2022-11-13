package com.neetcode;

import java.util.Stack;

public class PolishNotation {

    public static void main(String[] args) {
        PolishNotation polishNotation = new PolishNotation();
        polishNotation.evalRPN(new String[]{"10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+"});
    }

    public int evalRPN(String[] tokens) {

        Stack<Integer> stk = new Stack<>();

        for (String s : tokens) {

            switch (s) {
                case "+":
                    stk.push(stk.pop() + stk.pop());
                    break;
                case "-": {
                    int n1 = stk.pop();
                    int n2 = stk.pop();
                    stk.push(n2 - n1);
                    break;
                }
                case "*":
                    stk.push(stk.pop() * stk.pop());
                    break;
                case "/": {
                    int n1 = stk.pop();
                    int n2 = stk.pop();
                    stk.push(n2 / n1);
                    break;
                }
                default:
                    stk.push(Integer.parseInt(s));
                    break;
            }

        }

        return stk.peek();
    }
}
