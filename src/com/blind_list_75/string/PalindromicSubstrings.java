package com.blind_list_75.string;

public class PalindromicSubstrings {

    int count = 0;

    public static void main(String[] args) {
        PalindromicSubstrings palindromicSubstrings = new PalindromicSubstrings();
        palindromicSubstrings.countSubstrings("aaa");
    }

    public int countSubstrings(String s) {

        if (s == null) return 0;
        if (s.length() < 2) return s.length();

        for (int i = 0; i < s.length(); i++) {
            expand(i, i, s);
            expand(i, i + 1, s);
        }

        return count;
    }

    private void expand(int left, int right, String s) {

        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            count++;
            left--;
            right++;
        }
    }
}
