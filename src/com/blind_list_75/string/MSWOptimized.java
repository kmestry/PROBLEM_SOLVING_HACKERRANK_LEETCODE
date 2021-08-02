package com.blind_list_75.string;

import java.util.HashMap;
import java.util.Map;

public class MSWOptimized {

    public static void main(String[] args) {
        //"cabwefgewcwaefgcf"
        //"cae"
        MSWOptimized mswOptimized = new MSWOptimized();
        //"acbbaca"
        //  "aba"
        String result = mswOptimized.minWindow("acbbaca", "aba");
        System.out.println(result);
    }

    public String minWindow(String s, String t) {

        String result = "";
        if (s.length() < t.length()) return "";

        Map<Character, Integer> tMap = new HashMap<>();
        for (int i = 0; i < t.length(); i++) {
            tMap.merge(t.charAt(i), 1, Integer::sum);
        }

        int count = 0;

        int i = 0;
        int j = 0;

        Map<Character, Integer> sMap = new HashMap<>();

        while (j <= s.length()) {


            if (count == t.length()) {

                if (result.equals("")) {
                    result = s.substring(i, j);
                } else {
                    if (j - i < result.length()) {
                        result = s.substring(i, j);
                    }
                }
                char cI = s.charAt(i);
                if (sMap.containsKey(cI)) {
                    sMap.put(cI, sMap.get(cI) - 1);
                    if (sMap.get(cI) <= 0) {
                        sMap.remove(cI);
                    }
                }
                if (tMap.containsKey(cI) && !sMap.containsKey(cI) || (tMap.containsKey(cI) && tMap.get(cI) > sMap.get(cI))) {
                    count--;
                }
                i++;

            } else {
                if (j >= s.length()) break;
                char c = s.charAt(j);
                sMap.merge(c, 1, Integer::sum);
                if (tMap.containsKey(c)) {
                    if (sMap.get(c) <= tMap.get(c)) {
                        count++;
                    }
                }
                j++;
            }


        }


        return result;


    }
}
