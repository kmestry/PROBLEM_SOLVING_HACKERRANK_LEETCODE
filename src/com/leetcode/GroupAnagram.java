package com.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GroupAnagram {

    public static void main(String[] args) {
        List<List<String>> result = new GroupAnagram().groupAnagrams(new String[]{"tea", "", "eat", "", "tea", ""
        });
        System.out.println("result = " + result);
    }

    public List<List<String>> groupAnagrams(String[] strs) {

        Map<String, List<String>> map = new HashMap<>();
        for (int i = 0; i < strs.length; i++) {
            String unsortedString = strs[i];
            char[] chars = strs[i].toCharArray();
            Arrays.sort(chars);
            String string = String.valueOf(chars);

            if (!map.containsKey(string)) map.put(string, new ArrayList<>());

            map.get(string).add(unsortedString);
        }

        return new ArrayList<>(map.values());
    }
}
