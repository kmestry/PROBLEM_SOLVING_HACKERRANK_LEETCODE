package com.leetcode;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class InsertSpecialCharsInString {

    public static void main(String[] args) throws IOException {

        InputStream in;
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String inputString = bufferedReader.readLine().trim();

        InsertSpecialCharsInString obj = new InsertSpecialCharsInString();
        String result = obj.insertSpecialCharactersApproach2(inputString);
        System.out.println("result = " + result);
    }

    //21462675756
    //98676555533
    // result = 98*6765-5-5-5-3-3
    //23-9-7492*834092
    private String insertSpecialCharacters(String input) {

        int leftPointer = 0;
        int rightPointer = 1;
        StringBuilder stringBuilder = new StringBuilder(input);
        while (rightPointer < stringBuilder.length()) {

            int leftChar = (input.charAt(leftPointer));
            int rightChar = (input.charAt(rightPointer));

            if (leftChar <= 48 || rightChar <= 48) {
                leftPointer++;
                rightPointer++;
                continue;
            }

            leftChar = Character.getNumericValue(leftChar);
            rightChar = Character.getNumericValue(rightChar);
            if (leftChar % 2 == 0 && rightChar % 2 == 0) {
                stringBuilder.insert(rightPointer, "*");
                input = stringBuilder.toString();
            } else if (leftChar % 2 != 0 && rightChar % 2 != 0) {
                stringBuilder.insert(rightPointer, "-");
                input = stringBuilder.toString();
            }

            leftPointer++;
            rightPointer++;

        }


        return stringBuilder.toString();

    }


    //Ex1: Input: "98234925928"
    //
    //        Output: 98*234925-92*8
    //
    //Ex2: Input: "2397492834092"
    //
    //        Output: 23-9-7492*834092
    private String insertSpecialCharactersApproach2(String input) {


        StringBuilder sb = new StringBuilder();
        sb.append(Character.getNumericValue(input.charAt(0)));


        int left = 0;
        int right = 1;

        while (right < input.length()) {

            int leftIntVal = Character.getNumericValue(input.charAt(left));
            int rightIntVal = Character.getNumericValue(input.charAt(right));


            if (leftIntVal % 2 == 0 && rightIntVal % 2 == 0) {
                sb.append("*").append(rightIntVal);

            } else if (leftIntVal % 2 != 0 && rightIntVal % 2 != 0) {
                sb.append("-").append(rightIntVal);

            } else {
                sb.append(rightIntVal);
            }


            right++;
            left++;
        }

        return sb.toString();
    }
}
