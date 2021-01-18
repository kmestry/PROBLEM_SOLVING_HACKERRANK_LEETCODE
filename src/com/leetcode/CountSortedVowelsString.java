package com.leetcode;

import java.util.ArrayList;
import java.util.List;

public class CountSortedVowelsString {

    int resultCount = 0;

    public int countVowelStrings(int n) {
        char[] vowels = "aeiou".toCharArray();

        helper(n, new ArrayList<>(), vowels);
        return resultCount;

    }

    private void helper(int n, List<Character> list, char[] vowels) {

        if (list.size() > n) {
            return;
        }
        if (list.size() == n) {
            resultCount++;
            return;
        }

        for (char vowel : vowels) {

            char lastChar = list.size() > 0 ? list.get(list.size() - 1) : 0;
            if (vowel >= lastChar) {
                list.add(vowel);
                helper(n, list, vowels);
                list.remove(list.size() - 1);
            }
        }

    }
}
