package com.leetcode_restart;

public class ShuffleString400thProblem {

    public String restoreString(String s, int[] indices) {

        StringBuilder result = new StringBuilder();

        int index = 0;

        while (index < indices.length) {
            for (int i = 0; i < indices.length; i++) {
                if (indices[i] == index) {
                    result.append(s.charAt(i));
                    index++;
                }

            }
        }

        return result.toString();
    }
}
