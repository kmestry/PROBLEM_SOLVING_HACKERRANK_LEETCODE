package com.practise;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class GroupAnagram {

    public static void main(String[] args) {
        GroupAnagram groupAnagram = new GroupAnagram();
        List<List<String>> result = groupAnagram.groupAnagrams(new String[]{"eat", "tea", "tan", "ate", "nat", "bat"});
        System.out.println(result);
    }

    public List<List<String>> groupAnagrams(String[] strs) {


        Set<String> set = Arrays.stream(strs).collect(Collectors.toSet());
        List<List<String>> list = new ArrayList<>();
        boolean[] visited = new boolean[strs.length];

        int count = 0;
        for (int i = 0; i < strs.length; i++) {
            if (count == strs.length)
                break;
            if (visited[i]) continue;
            List<String> anagrams = new ArrayList<>();
            visited[i] = true;
            count++;
            for (int j = i + 1; j < strs.length; j++) {
                if (visited[j]) continue;
                if (isAnagram(strs[i], strs[j])) {
                    anagrams.add(strs[j]);
                    visited[j] = true;
                    count++;
                }

            }
            anagrams.add(strs[i]);
            list.add(anagrams);
        }

        return list;

    }


    private boolean isAnagram(String str1, String str2) {

        char[] chars = new char[128];

        for (int i = 0; i < str1.length(); i++) {
            chars[str1.charAt(i)]++;
        }

        for (int i = 0; i < str2.length(); i++) {
            chars[str2.charAt(i)]--;
        }

        for (int i = 0; i < 128; i++) {
            if (chars[i] != 0) {
                return false;
            }
        }
        return true;
    }
}
