package com.leetcode;

public class AddBinary {

    public static void main(String[] args) {
        String result = addBinary("11", "1");
        System.out.println("result = " + result);
    }

    public static String makeSmallStringEqual(String inputString, int length) {
        for (int i = 0; i < length; i++) {
            inputString = "0" + inputString;
        }
        return inputString;
    }

    // 11 and 1100001
    public static String addBinary(String a, String b) {

        String smallString = "";
        String bigString = "";
        int differenceInLength = Math.abs(a.length() - b.length());
        if (a.length() > b.length()) {
            smallString = "b";
            bigString = "a";
        } else {
            smallString = "a";
            bigString = "b";
        }
        String equalledString = makeSmallStringEqual(smallString.equals("a") ? a : b, differenceInLength);


        String result = getAdditionResult(bigString.equals("a") ? a : b, equalledString);

        return result;


    }

    private static String getAdditionResult(String bigString, String equalledString) {
        String result = "";

        int carry = 0;
        for (int i = equalledString.length() - 1; i >= 0; i--) {

            if (equalledString.charAt(i) + bigString.charAt(i) + carry == 98) {
                result = "0" + result;
                carry = 1;

            } else if (equalledString.charAt(i) + bigString.charAt(i) + carry == 99) {
                result = "1" + result;
                carry = 1;
            } else {
                result = charAddition(equalledString.charAt(i) + bigString.charAt(i) + carry) + result;
                carry = 0;
            }


        }
        return carry != 0 ? "1" + result : result;
    }

    private static String charAddition(int value) {
        switch (value) {
            case 96:
                return "0";
            case 97:
                return "1";
        }
        return null;
    }


}
