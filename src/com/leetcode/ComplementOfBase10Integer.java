package com.leetcode;

public class ComplementOfBase10Integer {

    public static void main(String[] args) {
        int result = new ComplementOfBase10Integer().bitwiseComplement(564);
        System.out.println("result = " + result);
    }

    public int bitwiseComplement(int N) {

        // 5 -- 10
        StringBuilder stringBuilder = new StringBuilder();
        int num = N;
        integerToBinaryString(stringBuilder, num);

        String binaryString = stringBuilder.reverse().toString();

        StringBuilder stringBuilderComplement = new StringBuilder();

        createComplementBinaryString(binaryString, stringBuilderComplement);

        String complementString = stringBuilderComplement.toString();

        int result = 0;
        int powerCounter = 0;

        result = binaryStringToInteger(complementString, result, powerCounter);


        return result;
    }

    private void createComplementBinaryString(String binaryString, StringBuilder stringBuilderComplement) {

        for (int i = 0; i < binaryString.length(); i++) {

            char c = binaryString.charAt(i);
            stringBuilderComplement.append(c == '0' ? "1" : "0");
        }
    }

    private int binaryStringToInteger(String complementString, double result, int powerCounter) {

        for (int i = complementString.length() - 1; i >= 0; i--) {
            char c = complementString.charAt(i);
            if (c == '1') {
                result += Math.pow(2, powerCounter);
            }

            powerCounter++;
        }
        return (int) result;
    }

    private void integerToBinaryString(StringBuilder stringBuilder, int num) {

        while (num > 0) {

            int bit = num % 2;
            stringBuilder.append(bit);
            num = num / 2;


        }
    }
}
