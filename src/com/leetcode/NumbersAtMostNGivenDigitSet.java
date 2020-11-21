package com.leetcode;

import java.util.ArrayList;
import java.util.List;

//backtracking approach.
public class NumbersAtMostNGivenDigitSet {

    int count = 0;

    public static void main(String[] args) {
        // int result = new NumbersAtMostNGivenDigitSet().atMostNGivenDigitSet(new String[]{"1", "2", "3", "4", "6", "7", "8", "9"}, 67688637);
        //int result = new NumbersAtMostNGivenDigitSet().atMostNGivenDigitSet(new String[]{"1", "3", "5", "7"}, 5367);
        int result = new NumbersAtMostNGivenDigitSet().atMostNGivenDigitSet(new String[]{"3", "5", "4"}, 676);
        System.out.println("result = " + result);
    }

    public int atMostNGivenDigitSet(String[] digits, int n) {
        // Find total number of digits - 1
        int numberOfDigits = (int) (Math.log10(n));

        // Find first digit
        int significantNum = n / (int) (Math.pow(10, numberOfDigits));

        int power = 1;
        for (int i = 0; i < numberOfDigits; i++) {
            count += Math.pow(digits.length, power);
            power++;
        }

        helper(digits, n, new ArrayList<String>(), numberOfDigits + 1, significantNum);
        return count;
    }

    private void helper(String[] digits, int maxNum, List<String> numStrings, int numberOfDigits, int significantNum) {

        if (numStrings.size() > numberOfDigits) {
            return;
        }

        if (numStrings.size() == numberOfDigits) {
            int number = 0;

            if (numStrings.size() > 0 && Integer.parseInt(numStrings.get(0)) <= significantNum) {
                for (int i = 0; i < numStrings.size(); i++) {
                    number = number * 10 + Integer.parseInt(numStrings.get(i));
                }
                if (number != 0 && number <= maxNum) {
                    count++;
                } else if (number != 0) {
                    return;
                }
            }
        }


        for (int i = 0; i < digits.length; i++) {
            numStrings.add(digits[i]);
            helper(digits, maxNum, numStrings, numberOfDigits, significantNum);
            numStrings.remove(numStrings.size() - 1);
        }
    }
}
