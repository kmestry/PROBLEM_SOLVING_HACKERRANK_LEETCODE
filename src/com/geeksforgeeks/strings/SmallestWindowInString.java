package com.geeksforgeeks.strings;

import java.util.HashMap;
import java.util.Map;

public class SmallestWindowInString {
    public static void main(String[] args) {

        SmallestWindowInString smallestWindowInString = new SmallestWindowInString();
        // String result = smallestWindowInString.smallestWindow("zoomlazapzo", "oza");
        // String result = smallestWindowInString.smallestWindow("a", "a");
        String result = smallestWindowInString.smallestWindow("cabwefgewcwaefgcf", "cae");
        System.out.println(result);

       /* "cabwefgewcwaefgcf"
        "cae"*/
        //"cwae"
    }

    //    /
   /* S = "zoomlazapzo"
      P = "oza"         */
    public String smallestWindow(String s, String p) {
        // Your code here
        if (p.length() > s.length()) return "";
        Map<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < p.length(); i++) {
            char c = p.charAt(i);
            map.merge(c, 1, Integer::sum);
        }
        int left = 0;
        int right = 0;
        Map<Character, Integer> subStringMap = new HashMap<>();
        String result = "";
        int count = 0;
        while (right <= s.length()) {

            if (count == p.length()) {
                if (result.length() == 0) {
                    result = s.substring(left, right);
                } else if (right - left < result.length()) {
                    result = s.substring(left, right);
                }
                while (left <= right && count == p.length()) {
                    char leftChar = s.charAt(left);
                    if (subStringMap.containsKey(leftChar) && subStringMap.get(leftChar) > 0) {
                        subStringMap.put(leftChar, subStringMap.get(leftChar) - 1);
                    }
                    if (map.containsKey(leftChar)) {
                        if (subStringMap.get(leftChar) < map.get(leftChar)) {
                            if (right - left < result.length()) {
                                result = s.substring(left, right);
                            }
                            count--;
                        }
                    }
                    left++;
                }
            } else {

                if (right >= s.length()) {
                    break;
                }
                char c = s.charAt(right);
                subStringMap.merge(c, 1, Integer::sum);
                if (map.containsKey(c)) {
                    if (subStringMap.get(c) <= map.get(c)) {
                        count++;
                    }
                }
                right++;
            }
        }

        return result;
    }
}
