package com.blind_list_75.string;

public class ValidAnagram {
    public boolean isAnagram(String s, String t) {

        char[] chars = new char[128];

        for (int i = 0; i < s.length(); i++) {
            chars[s.charAt(i)]++;
        }

        for (int i = 0; i < t.length(); i++) {
            chars[t.charAt(i)]--;
        }

        for (int i = 0; i < chars.length; i++) {
            if (chars[i] != 0) {
                return false;
            }
        }

        return true;

    }

}
