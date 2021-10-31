package com.leetcode_restart;

public class ReverseWordsPart3 {
    public String reverseWords(String s) {
        StringBuilder result = new StringBuilder();

        String[] words = s.split(" ");
        int l = words.length;
        int i = 0;

        for (String word : words) {
            String reversed = reverse(word);

            if (i != l - 1) {
                result.append(reversed).append(" ");
            } else {
                result.append(reversed);
            }
            i++;
        }
        return result.toString();
    }

    private String reverse(String word) {

        //"lets"
        char[] cArray = word.toCharArray();
        StringBuilder reversed = new StringBuilder();
        int l = 0;
        int r = cArray.length - 1;

        while (l < r) {

            char lC = cArray[l];
            char rC = cArray[r];

            cArray[l] = rC;
            cArray[r] = lC;

            l++;
            r--;
        }

        for (char c : cArray) {
            reversed.append(c);
        }

        return reversed.toString();
    }
}
