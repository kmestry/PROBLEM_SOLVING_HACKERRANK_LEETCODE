package com.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LetterCombinationsOfPhoneNumber {

    final static Map<Character, String> map = new HashMap<>();

    static {

        map.put('2', "abc");
        map.put('3', "def");
        map.put('4', "ghi");
        map.put('5', "jkl");
        map.put('6', "mno");
        map.put('7', "pqrs");
        map.put('8', "tuv");
        map.put('9', "wxyz");

    }

    List<String> list = new ArrayList<>();

    public static void main(String[] args) {
        new LetterCombinationsOfPhoneNumber().letterCombinations("23");
    }

    public List<String> letterCombinations(String digits) {

        helper(digits, new StringBuilder(), 0);

        return list;
    }

    private void helper(String digits, StringBuilder sb, int index) {

        if (sb.length() == digits.length()) {
            list.add(sb.toString());
            return;
        }

        String temp = map.get(digits.charAt(index));
        for (int i = 0; i < temp.length(); i++) {
            sb.append(temp.charAt(i));
            helper(digits, sb, index + 1);
            sb.deleteCharAt(sb.length() - 1);
        }

    }
}
