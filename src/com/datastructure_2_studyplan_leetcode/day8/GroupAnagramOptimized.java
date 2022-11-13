package com.datastructure_2_studyplan_leetcode.day8;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GroupAnagramOptimized {

    public static void main(String[] args) {
        GroupAnagramOptimized groupAnagramOptimized = new GroupAnagramOptimized();
        groupAnagramOptimized.groupAnagrams(new String[]{"eat", "tea", "tan", "ate", "nat", "bat"});
    }

    public List<List<String>> groupAnagrams(String[] strs) {

        Map<String, List<String>> map = new HashMap<>();

        for (String str : strs) {


            char[] arr = new char[26];

            for (char c : str.toCharArray()) {
                arr[c - 'a']++;
            }
            String keyStr = String.valueOf(arr);

            //System.out.println(keyStr);

            if (!map.containsKey(keyStr)) map.put(keyStr, new ArrayList<>());

            map.get(keyStr).add(str);

        }

        return new ArrayList<>(map.values());
    }
}
