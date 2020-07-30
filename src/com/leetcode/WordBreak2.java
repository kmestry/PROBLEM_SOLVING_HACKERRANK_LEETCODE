package com.leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class WordBreak2 {

    int minimumLengthDictionaryWord = 0;

    public static void main(String[] args) {

        List<String> result = new WordBreak2().wordBreak("catsanddog", Arrays.asList("cat", "cats", "and", "sand", "dog"));
        System.out.println("result = " + result);
    }

    public List<String> wordBreak(String s, List<String> wordDict) {
        return DFS(s, new HashSet<>(wordDict), new HashMap<String, LinkedList<String>>());
    }

    // DFS function returns an array including all substrings derived from s.
    List<String> DFS(String s, Set<String> wordDict, HashMap<String, LinkedList<String>> map) {
        if (map.containsKey(s))
            return map.get(s);

        LinkedList<String> res = new LinkedList<String>();
        if (s.length() == 0) {
            res.add("");
            return res;
        }
        for (String word : wordDict) {
            if (s.startsWith(word)) {
                List<String> sublist = DFS(s.substring(word.length()), wordDict, map);
                for (String sub : sublist)
                    res.add(word + (sub.isEmpty() ? "" : " ") + sub);
            }
        }
        map.put(s, res);
        return res;
    }

}
