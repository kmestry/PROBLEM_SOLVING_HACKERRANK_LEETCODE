package com.geeksforgeeks.strings;

public class FindSumOfNumbers {


    public static void main(String[] args) {
        FindSumOfNumbers findSumOfNumbers = new FindSumOfNumbers();
        findSumOfNumbers.findSum("1abc2343");
    }

    public long findSum(String str) {
        // your code here
        long result = 0;

        long resultTillNow = 0;

        for (int i = 0; i < str.length(); i++) {

            int val = str.charAt(i);

            if (!(val >= 48 && val < 58) && resultTillNow == 0) {
                continue;
            }

            if (val >= 48 && val < 58) {
                if (resultTillNow == 0) {
                    resultTillNow = (val - 48);
                } else {
                    resultTillNow = resultTillNow * 10 + (val - 48);
                }
            } else {
                result += resultTillNow;
                resultTillNow = 0;
            }
        }
        if (resultTillNow > 0) {
            result += resultTillNow;
        }

        return result;
    }
}
