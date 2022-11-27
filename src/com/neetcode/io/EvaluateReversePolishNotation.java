package com.neetcode.io;

import java.util.Stack;

public class EvaluateReversePolishNotation {
    public int evalRPN(String[] tokens) {

        Stack<Integer> stk = new Stack<>();

        for (String str : tokens) {

            if (str.equals("+") || str.equals("-") || str.equals("*") || str.equals("/")) {

                int b = stk.pop();
                int a = stk.pop();

                switch (str) {
                    case "+" -> {
                        int c = a + b;

                        stk.push(c);
                    }
                    case "-" -> {
                        int c = a - b;

                        stk.push(c);
                    }
                    case "*" -> {
                        int c = a * b;

                        stk.push(c);
                    }
                    default -> {
                        int c = a / b;

                        stk.push(c);
                    }
                }


            } else {
                stk.push(Integer.valueOf(str));
            }
        }

        return stk.pop();

    }
}
