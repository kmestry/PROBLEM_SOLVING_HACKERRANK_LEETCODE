package com.leetcode;

import java.util.Arrays;

public class PlusOne66 {
    public static int[] plusOne(int[] digits) {
        int lengthOfArray = digits.length;
        int[] oneArray = new int[lengthOfArray];


        if (digits[lengthOfArray - 1] != 9) {
            digits[lengthOfArray - 1] = digits[lengthOfArray - 1] + 1;
            return digits;
        }

        for (int i = 0; i < lengthOfArray - 1; i++) {
            oneArray[i] = 0;
        }
        //last digit is always 1
        oneArray[lengthOfArray - 1] = 1;

        //  999
        //  001
        int carryForward = 0;
        int[] resultArray = new int[digits.length + 1];
        for (int i = digits.length - 1; i >= 0; i--) {

            int additionResult = oneArray[i] + digits[i] + carryForward;
            if (additionResult > 9) {
                int remainder = additionResult % 10;
                int quotient = additionResult / 10;
                carryForward = quotient;
                resultArray[i + 1] = remainder;
            } else {
                resultArray[i + 1] = additionResult;
                carryForward = 0;
            }

        }
        if (carryForward != 0) {
            resultArray[0] = carryForward;
        } else {
            int[] resultArrayRemoveFirstElement = Arrays.copyOfRange(resultArray, 1, resultArray.length);
            return resultArrayRemoveFirstElement;
        }


        return resultArray;

    }

    public static void main(String[] args) {

        int[] result = plusOne(new int[]{9, 9, 9});

        for (int i = 0; i < result.length; i++) {
            System.out.print(result[i] + " ");
        }

    }
}
