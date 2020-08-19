package com.leetcode;

import java.util.ArrayList;
import java.util.List;

import static java.lang.Integer.parseInt;

public class NumbersWithSameConsecutiveDifferences {


    //[10,12,21,23,32,34,43,45,54,56,65,67,76,78,87,89,98]

    /*N = 3, K = 7
    Output: [181,292,707,818,929]*/
    public static void main(String[] args) {

        int[] result = new NumbersWithSameConsecutiveDifferences().numsSameConsecDiff(7, 2);

        for (int i = 0; i < result.length; i++) {
            System.out.print(result[i] + " ");
        }
    }

    boolean checkNumber(Integer number, int K) {

        String numberString = number.toString();

        for (int i = 0; i < numberString.length() - 1; i++) {
            if (Math.abs(parseInt(String.valueOf(numberString.charAt(i))) - parseInt(String.valueOf(numberString.charAt(i + 1)))) == K) {
                continue;

            } else {
                return false;
            }
        }

        return true;
    }

    public int[] numsSameConsecDiff(int N, int K) {

        List<Integer> resultList = new ArrayList<>();

        String startIndex = "";
        for (int i = 0; i < N - 1; i++) {
            startIndex += "0";
        }
        startIndex = "1" + startIndex;

        if (N == 1) startIndex = "0";

        String endIndex = "";
        for (int i = 0; i < N; i++) {
            endIndex += "9";
        }

        int start = Integer.parseInt(startIndex);
        int end = Integer.parseInt(endIndex);

        for (int i = start; i <= end; i++) {

            boolean isDifferenceK = checkNumber(i, K);
            if (isDifferenceK) resultList.add(i);

        }


        return resultList.stream().mapToInt(value -> value).toArray();

    }
}
