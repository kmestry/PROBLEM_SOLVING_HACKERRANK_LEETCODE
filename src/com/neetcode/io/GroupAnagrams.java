package com.neetcode.io;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GroupAnagrams {

    public static void main(String[] args) {
        new GroupAnagrams().groupAnagrams(new String[]{"eat", "tea", "tan", "ate", "nat", "bat"});
    }

    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();

        for (String str : strs) {
            String key = createHashMapKey(str);

            if (map.containsKey(key)) {
                List<String> listStr = map.get(key);
                listStr.add(str);
                map.put(key, listStr);
            } else {
                List<String> list = new ArrayList<>();
                list.add(str);
                map.put(key, list);
            }
        }
        System.out.println(map);

        return new ArrayList<>(map.values());
    }

    public String createHashMapKey(String s) {

        int[] arr = new int[26];

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            arr[c - 'a']++;
        }

        StringBuilder strBuilder = new StringBuilder();

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != 0) {
                strBuilder.append(arr[i]).append((char) (i + 'a'));
            }
        }

        System.out.println(strBuilder);
        return strBuilder.toString();
    }
}
