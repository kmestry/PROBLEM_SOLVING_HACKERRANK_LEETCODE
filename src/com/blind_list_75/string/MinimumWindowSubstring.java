package com.blind_list_75.string;

import java.util.HashMap;
import java.util.Map;

public class MinimumWindowSubstring {

    public static void main(String[] args) {
        MinimumWindowSubstring minimumWindowSubstring = new MinimumWindowSubstring();
        //String result = minimumWindowSubstring.minWindow("ADOBECODEBANC", "ABC");
        //"cabwefgewcwaefgcf"
        //"cae"
        String result = minimumWindowSubstring.minWindow("cabwefgewcwaefgcf", "cae");
        System.out.println("==" + result);
    }

    public String minWindow(String s, String t) {
        if (s.length() < t.length()) return "";
        String result = "";
        Map<Character, Integer> tMap = new HashMap<>();

        for (int i = 0; i < t.length(); i++) {
            tMap.merge(t.charAt(i), 1, Integer::sum);
        }
        //ystem.out.println(tMap);

        int i = 0;
        int j = t.length() - 1;
        Map<Character, Integer> sMap = new HashMap<>();
        for (int k = i; k <= j; k++) {
            sMap.merge(s.charAt(k), 1, Integer::sum);
        }

        while (j < s.length()) {

            if (areMapsMatching(sMap, tMap)) {


                //   System.out.println("==" + (j - i + 1));

                if (result.equals(""))
                    result = s.substring(i, j + 1);
                else if (j - i + 1 <= result.length())
                    result = s.substring(i, j + 1);
                //System.out.println("=="+ result);
                sMap.put(s.charAt(i), sMap.get(s.charAt(i)) - 1);
                if (sMap.get(s.charAt(i)) <= 0) {
                    sMap.remove(s.charAt(i));
                }
                i++;

            } else {
                j++;
                if (j >= s.length()) break;
                sMap.merge(s.charAt(j), 1, Integer::sum);
            }
        }

        return result;
    }


    private boolean areMapsMatching(Map<Character, Integer> sMap,
                                    Map<Character, Integer> tMap) {

        for (Map.Entry<Character, Integer> entry : tMap.entrySet()) {
            Character c = entry.getKey();
            int count = entry.getValue();
            if (sMap.containsKey(c) && count <= sMap.get(c)) {
                continue;
            } else {
                return false;
            }
        }
        return true;
    }
}
