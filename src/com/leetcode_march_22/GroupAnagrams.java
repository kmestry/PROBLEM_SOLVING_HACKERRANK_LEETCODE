package com.leetcode_march_22;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class GroupAnagrams {

    public static void main(String[] args) {
        GroupAnagrams groupAnagrams = new GroupAnagrams();
        groupAnagrams.groupAnagrams(new String[]{"eat", "tea", "tan", "ate", "nat", "bat"});
    }


    public List<List<String>> groupAnagrams(String[] strs) {

        List<int[]> list = new ArrayList<>();

        for (String str : strs) {

            int[] chr = new int[26];

            for (int i = 0; i < str.length(); i++) {
                char c = str.charAt(i);

                chr[c - 'a']++;
            }

            list.add(chr);

        }

        List<List<String>> result = new ArrayList<>();
        List<String> inList = new ArrayList<>();
        Set<Integer> visited = new HashSet<>();

        for (int i = 0; i < strs.length; i++) {
            String str = strs[i];
            if (visited.contains(i)) continue;
            inList.add(str);
            for (int j = i + 1; j < strs.length; j++) {

                int[] chr_outer = list.get(i);
                int[] chr_inner = list.get(j);

                boolean isMismatch = false;
                for (int k = 0; k < 26; k++) {
                    if (chr_outer[k] != chr_inner[k]) {
                        isMismatch = true;
                        break;
                    }
                }
                if (!isMismatch) {
                    inList.add(strs[j]);
                    visited.add(j);
                }

            }
            result.add(new ArrayList<>(inList));
            inList.clear();

        }


        return result;
    }
}
