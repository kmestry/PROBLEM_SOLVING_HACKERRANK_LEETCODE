package com.blind_list_75.string;

import java.util.*;

public class GroupAnagrams {

    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> list = new ArrayList<>();

        Map<String, List<String>> map = new HashMap<>();

        for (int i = 0; i < strs.length; i++) {
            String str = strs[i];

            char[] chars = str.toCharArray();
            Arrays.sort(chars);

            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < chars.length; j++) {
                sb.append(chars[j]);
            }

            String sortedStr = sb.toString();

            if (map.containsKey(sortedStr)) {
                List<String> los = map.get(sortedStr);
                los.add(str);
                map.put(sortedStr, los);
            } else {
                List<String> los = new ArrayList<>();
                los.add(str);
                map.put(sortedStr, los);
            }

        }

        for (Map.Entry<String, List<String>> e : map.entrySet()) {
            list.add(e.getValue());
        }

        return list;
    }
}
