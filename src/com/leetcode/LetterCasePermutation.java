package com.leetcode;

import java.util.ArrayList;
import java.util.List;

public class LetterCasePermutation {

    public List<String> letterCasePermutation(String S) {
        char[] chArray = S.toCharArray();

        List<String> result = new ArrayList<>();
        helper(chArray, 0, result);

        return result;

    }

    private void helper(char[] array, int index, List<String> list) {

        if (index == array.length) {
            list.add(new String(array));
            return;
        }

        if (Character.isDigit(array[index])) {
            helper(array, index + 1, list);
        } else {

            array[index] = Character.toLowerCase(array[index]);
            helper(array, index + 1, list);

            array[index] = Character.toUpperCase(array[index]);
            helper(array, index + 1, list);
        }

    }
}
