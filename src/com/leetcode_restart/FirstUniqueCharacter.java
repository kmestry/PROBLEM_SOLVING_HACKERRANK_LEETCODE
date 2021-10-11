package com.leetcode_restart;

import org.jetbrains.annotations.NotNull;

public class FirstUniqueCharacter {


    public int firstUniqChar(@NotNull String s) {

        int[] arr = new int[26];

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            arr[c - 'a']++;

        }


        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (arr[c - 'a'] == 1) {
                return i;
            }
        }
        return -1;
    }

}
