package com.leetcode;

public class AddStrings415 {

    public static String addStrings(String num1, String num2) {
        String resultString = "";
        int carryForward = 0;
        String biggerString = "";
        String smallerString = "";
        if (num1.length() == num2.length() && num1.length() == 1) {
            return (String.valueOf(num1.charAt(0) - '0' + num2.charAt(0) - '0'));
        }
        if (num1.length() >= num2.length()) {
            biggerString = num1;
            smallerString = num2;
        } else {
            biggerString = num2;
            smallerString = num1;
        }

        resultString = calculateSum(biggerString, smallerString, carryForward, resultString);


        System.out.println("resultString = " + resultString);
        return resultString;

    }

    public static String calculateSum(String biggerString, String smallerString, int carryForward, String resultString) {

        int length = biggerString.length() - smallerString.length();

        int counterSmallString = 1;
        int smallerStringLengthCounter = smallerString.length();
        for (int i = biggerString.length() - 1; i >= 0; i--) {
            int result = 0;
            if (length != 0) {
                if (smallerStringLengthCounter > 0)
                    result = biggerString.charAt(i) - '0' + smallerString.charAt(smallerString.length() - counterSmallString) - '0' + carryForward;
                else
                    result = biggerString.charAt(i) - '0' + carryForward;
            } else {
                result = biggerString.charAt(i) - '0' + smallerString.charAt(i) - '0' + carryForward;
            }
            if (result > 9) {
                int quotient = result / 10;
                int remainder = result % 10;
                carryForward = quotient;
                resultString = remainder + resultString;
            } else {
                resultString = result + resultString;
                carryForward = 0;
            }

            counterSmallString++;
            smallerStringLengthCounter--;

        }
        if (carryForward != 0) {
            resultString = carryForward + resultString;
        }
        return resultString;
    }

    public static void main(String[] args) {

        String result = addStrings("9", "99");
        System.out.println("result = " + result);


    }


}
