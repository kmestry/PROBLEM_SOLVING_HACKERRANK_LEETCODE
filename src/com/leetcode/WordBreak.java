package com.leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WordBreak {

    /*
    * "applepenapple"
["apple","pen"]
*
*
* "abcd"
["a","abc","b","cd"]
    * */
/// BRUTE FORCE RECURSIVE> EARLY BREAK...
    //Time Complexity is exponential  O(2^n)
    //TOP DOWN O(n^2)

    Map<String, Boolean> map = new HashMap<>();

    public static void main(String[] args) {
        boolean res = new WordBreak().wordBreak("abcd", Arrays.asList("a", "abc", "b", "cd"));
        System.out.println("res = " + res);
    }

    public boolean wordBreak(String s, List<String> wordDict) {

        //https://www.youtube.com/watch?v=1U4jQusbeJc
        if (s.equals("") || s.length() == 0) return true;
        if (map.containsKey(s))
            return map.get(s);
        for (int i = 0; i < wordDict.size(); i++) {
            boolean res = false;
            String word = wordDict.get(i);


            if (word.length() > s.length()) continue;
            String compare = s.substring(0, word.length());

            if (compare.equals(word)) {

                res = wordBreak(s.substring(word.length()), wordDict);

            }

            if (res) {
                map.put(s, true);
                return true;
            }
        }
        map.put(s, false);
        return false;
    }
}
