package com.leetcode;

public class ExcelSheetColumnNumber {

    public int titleToNumber(String s) {

        int power = 0;
        int result = 0;

        for (int i = s.length() - 1; i >= 0; i--) {
            int value = s.charAt(i) - 'A' + 1; // this will give the value according to the letter. A will give 1 , B will give 2 and so on.
            result = result + ((int) Math.pow(26, power) * value); // formula is charValue*26^index. increment index from left to right. We start the loop from end to beginning.
            power++;
        }

        return result;
    }
}
