package com.codility;

import java.util.HashSet;
import java.util.Set;

public class MinimumDeletionsToMakeCharacterUnique {

    public static void main(String[] args) {
        MinimumDeletionsToMakeCharacterUnique makeCharacterUnique = new MinimumDeletionsToMakeCharacterUnique();
        makeCharacterUnique.minDeletions("ceabaacb");
    }

    public int minDeletions(String s) {

        char[] chars = new char[128];

        for (int i = 0; i < s.length(); i++) {
            chars[s.charAt(i)]++;
        }
        Set<Integer> seen = new HashSet<>();
        int result = 0;

        for (int aChar : chars) {
            int freq = aChar;
            while (freq > 0) {
                if (!seen.contains(freq)) {
                    seen.add(freq);
                    break;
                }
                freq--;
                result++;
            }
        }

        return result;
    }
}
