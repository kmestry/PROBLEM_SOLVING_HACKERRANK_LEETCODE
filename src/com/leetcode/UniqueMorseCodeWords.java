package com.leetcode;

import java.util.HashSet;
import java.util.Set;

public class UniqueMorseCodeWords {

    String[] morseCodeArray = new String[]{".-", "-...", "-.-.", "-..", ".", "..-.", "--.", "....", "..", ".---", "-.-", ".-..", "--",
            "-.", "---", ".--.", "--.-", ".-.", "...", "-", "..-", "...-", ".--", "-..-", "-.--", "--.."};

    Set<String> morseSet = new HashSet<>();

    public int uniqueMorseRepresentations(String[] words) {


        for (int i = 0; i < words.length; i++) {
            String s = words[i];
            StringBuilder morseSb = new StringBuilder();
            for (int j = 0; j < s.length(); j++) {
                int pos = s.charAt(j) - 'a';
                morseSb.append(morseCodeArray[pos]);
            }
            morseSet.add(morseSb.toString());
        }

        return morseSet.size();
    }
}

