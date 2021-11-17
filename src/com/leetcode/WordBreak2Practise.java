package com.leetcode;

import java.util.*;

public class WordBreak2Practise {


    public static void main(String[] args) {
        List<String> result = new WordBreak2Practise().wordBreak("catsanddog", Arrays.asList("cat", "cats", "and", "sand", "dog"));
        System.out.println("result = " + result);
    }

    public List<String> wordBreak(String s, List<String> wordDict) {
        Set<String> dictionarySet = new HashSet<>(wordDict);
        return wordBreakHelper(s, dictionarySet, new HashMap<>());

    }

    public List<String> wordBreakHelper(String s, Set<String> dictionarySet, HashMap<String, List<String>> map) {

        if (map.containsKey(s))
            return map.get(s);

        List<String> result = new ArrayList<>();
        if (s.length() == 0) {  //base condition/
            result.add("");
            return result;
        }

        for (String word : dictionarySet) {
            if (word.length() <= s.length()) {
                String startOfString = s.substring(0, word.length()); //check if the start of string matches word in dictionary.
                if (startOfString.equals(word)) {

                    List<String> subList = wordBreakHelper(s.substring(word.length()), dictionarySet, map);
                    for (String listWord : subList) {
                        String appender = listWord.isEmpty() ? "" : " ";
                        result.add(word + appender + listWord);
                    }

                }
            }
        }

        map.put(s, result);
        return result;

    }

}
