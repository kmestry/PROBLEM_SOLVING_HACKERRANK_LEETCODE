package com.leetcode;

public class LengthOfLastWord {

    public int lengthOfLastWord(String s) {
        String[] array = s.split(" ");

        if (array.length == 0) return 0;

        return array[array.length - 1].length();
    }

    public int lengthOfLastWordOptimized(String inputString) {

        // inputString = inputString.trim();
        int count = 0;
        for (int i = inputString.length() - 1; i >= 0; i--) {
            if (inputString.charAt(i) == 32) {

                if (count > 0) return count;
            } else {
                count++;
            }
        }

        return count;
    }
}
