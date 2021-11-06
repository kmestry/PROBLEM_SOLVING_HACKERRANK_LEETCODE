package com.leetcode_restart;

import java.util.ArrayList;
import java.util.List;

public class LetterCasePermutation {

    public List<String> letterCasePermutation(String s) {

        char[] charArray = s.toCharArray();
        List<String> result = new ArrayList<>();
        helper(charArray, 0, result);
        return result;
    }

    private void helper(char[] chars, int index, List<String> list) {

        if (index == chars.length) {
            list.add(new String(chars));
            return;
        }

        if (Character.isDigit(chars[index])) {
            helper(chars, index + 1, list);
        } else {

            chars[index] = Character.toLowerCase(chars[index]);
            helper(chars, index + 1, list);

            chars[index] = Character.toUpperCase(chars[index]);
            helper(chars, index + 1, list);
        }
    }
}
