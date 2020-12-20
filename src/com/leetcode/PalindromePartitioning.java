package com.leetcode;

import java.util.ArrayList;
import java.util.List;

public class PalindromePartitioning {

    List<List<String>> resultList = new ArrayList<>();

    public static void main(String[] args) {
        new PalindromePartitioning().partition("aab");
    }

    public List<List<String>> partition(String s) {

        List<String> list = new ArrayList<>();

        generatePalindromes(s, list);

        return resultList;


    }


    private void generatePalindromes(String str, List<String> list) {
        if (str.length() == 0) {
            resultList.add(new ArrayList<>(list));
            return;
        }

        for (int i = 0; i < str.length(); i++) {
            String prefix = str.substring(0, i + 1);

            if (checkPalindrome(prefix)) {
                list.add(prefix);
                String remaining = str.substring(i + 1);
                generatePalindromes(remaining, list);
                list.remove(list.size() - 1);
            }

        }
    }

    private boolean checkPalindrome(String input) {
        int left = 0;
        int right = input.length() - 1;

        while (left <= right) {
            char l = input.charAt(left);
            char r = input.charAt(right);
            if (l != r) {
                return false;
            }
            left++;
            right--;
        }

        return true;
    }
}
