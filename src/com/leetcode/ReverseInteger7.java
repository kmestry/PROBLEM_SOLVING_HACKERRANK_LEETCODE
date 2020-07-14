package com.leetcode;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

public class ReverseInteger7 {


    // 123

    public static void main(String[] args) {
        int result = new ReverseInteger7().reverse(-2147483412);
        System.out.println("result = " + result);
    }

    //1534236469
    //2147483647
    //2143847412

    public int reverse(int x) {
        System.out.println("Integer.MAX_VALUE = " + Integer.MAX_VALUE);
        Stack<Integer> integerStack = new Stack<>();
        int multiplier = 1;
        int reversedDigit = 0;
        boolean isNumberPositive = x > 0;
        if (!isNumberPositive) {
            x = -1 * x;
        }
        while (x > 0) {
            int remainder = x % 10;
            integerStack.push(remainder);
            x = x / 10;
        }

        int[] maxIntegerArray = new int[]{2, 1, 4, 7, 4, 8, 3, 6, 4, 7};
        if (integerStack.size() == 10) {
            Deque<Integer> integerDeque = new ArrayDeque<>(integerStack);
            int i = 0;
            while (!integerDeque.isEmpty()) {
                int value = integerDeque.removeFirst();
                int ithDigitOfMaxInteger = maxIntegerArray[i];
                if (value == ithDigitOfMaxInteger) {
                    i++;
                    continue;
                } else if (i > 0 && value < ithDigitOfMaxInteger) break;
                else if (value > ithDigitOfMaxInteger) return 0;
                i++;
            }
        }

        while (!integerStack.isEmpty()) {
            reversedDigit += multiplier * integerStack.pop();
            multiplier = multiplier * 10;

        }

        return isNumberPositive ? reversedDigit : -1 * reversedDigit;
    }
}
