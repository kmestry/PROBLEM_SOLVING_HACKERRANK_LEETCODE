package com.datastructure_2_studyplan_leetcode.day8;

import java.util.*;

public class GroupAnagrams {

    public static void main(String[] args) {
        GroupAnagrams groupAnagrams = new GroupAnagrams();
        groupAnagrams.groupAnagrams(new String[]{"eat", "tea", "tan", "ate", "nat", "bat"});
    }

    public List<List<String>> groupAnagrams(String[] strs) {


        List<String> sortedList = new ArrayList<>();
        List<List<String>> res = new ArrayList<>();
        for (String str : strs) {
            char[] chArr = str.toCharArray();
            Arrays.sort(chArr);
            sortedList.add(new String(chArr));
        }

        Set<Integer> visited = new HashSet<>();

        for (int i = 0; i < strs.length; i++) {
            if (!visited.contains(i)) {
                List<String> list = new ArrayList<>();

                for (int j = i + 1; j < strs.length; j++) {
                    if (sortedList.get(i).equals(sortedList.get(j))) {
                        list.add(strs[j]);
                        visited.add(j);
                    }
                }
                list.add(strs[i]);
                visited.add(i);
                res.add(list);
            }
        }

        return res;

    }
}
