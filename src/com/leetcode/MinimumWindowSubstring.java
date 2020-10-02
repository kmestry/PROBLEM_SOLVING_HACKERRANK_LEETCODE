package com.leetcode;

import java.util.HashMap;
import java.util.Map;

//Time LIMIT exceeded solution.
public class MinimumWindowSubstring {

    public static void main(String[] args) {

        /*.
        "cabwefgewcwaefgcf"
"cae"

        * */
        String s = new MinimumWindowSubstring().minWindow("cabwefgewcwaefgcf", "cae");
        System.out.println("s = " + s);
    }

    //"ADOBECODEBANC", T = "ABC"
    public String minWindow(String s, String t) {

        int left = 0;
        int right = 0;
        String minString = "";

        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < t.length(); i++) {

            char c = t.charAt(i);

            if (map.containsKey(c)) {
                map.put(c, map.get(c) + 1);
            } else {
                map.put(c, 1);
            }
        }

        while (right < s.length()) {
            String checkString = s.substring(left, right + 1); //substring end is exclusive
            if (checkString.length() < t.length()) {
                right++;
            } else {
                Map<Character, Integer> checkMap = new HashMap<>();
                for (int i = 0; i < checkString.length(); i++) {
                    char c = checkString.charAt(i);

                    if (checkMap.containsKey(c)) {
                        checkMap.put(c, checkMap.get(c) + 1);
                    } else {
                        checkMap.put(c, 1);
                    }
                }
                ////"ADOBECODEBANC", T = "ABC"
                boolean flag = checkIfSubStringExists(map, checkMap);
                if (flag) {
                    if (minString.equals(""))
                        minString = checkString;
                    else if (checkString.length() < minString.length())
                        minString = checkString;
                    left++;
                } else {
                    right++;
                }
            }
        }

        return minString;
    }

    private boolean checkIfSubStringExists(Map<Character, Integer> map, Map<Character, Integer> checkMap) {
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            Character c = entry.getKey();
            Integer charCount = entry.getValue();

            if (checkMap.containsKey(c) && checkMap.get(c) >= (charCount)) {
                //continue;
            } else {
                return false;
            }
        }

        return true;
    }
}
