package com.datastructure_2_studyplan_leetcode.day7;

import java.util.HashMap;
import java.util.Map;

public class WordPattern {

    public boolean wordPattern(String pattern, String s) {


        Map<String, Integer> mapS = new HashMap<>();

        String[] words = s.split(" ");

        int currentNum = 1;
        String sFormed = "";
        for (String word : words) {
            if (mapS.containsKey(word)) {
                sFormed += mapS.get(word);
                continue;
            }

            mapS.put(word, currentNum);
            sFormed += mapS.get(word);
            currentNum++;
        }

        String pFormed = "";
        Map<Character, Integer> mapP = new HashMap<>();
        currentNum = 1;
        for (int i = 0; i < pattern.length(); i++) {
            char c = pattern.charAt(i);

            if (mapP.containsKey(c)) {
                pFormed += mapP.get(c);
                continue;
            }

            mapP.put(c, currentNum);
            pFormed += mapP.get(c);
            currentNum++;
        }


        return sFormed.equals(pFormed);
    }
}
