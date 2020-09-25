package com.leetcode;

import java.util.Arrays;

public class LargestNumber {

    public static void main(String[] args) {
        new LargestNumber().largestNumber(new int[]{3, 30, 34, 5, 9
        });
    }

    public String largestNumber(int[] nums) {

        String[] inputArray = new String[nums.length];

        int index = 0;
        for (int i : nums) {
            inputArray[index] = String.valueOf(i);
            index++;

        }

        Arrays.sort(inputArray, (s1, s2) -> (s2 + s1).compareTo(s1 + s2));

        StringBuilder sb = new StringBuilder();

        for (String s : inputArray) {
            sb.append(s);

        }

        if (inputArray[0].equals("0"))
            return "0";

        return sb.toString();

    }
}
