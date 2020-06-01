package com.hackerrank.Strings;

public class AnagramCopied {
    static int anagram(String s) {
        int n = s.length(), temp = 0, count = 0;
        if (n % 2 != 0) {
            return -1;
        }
        String s1 = s.substring(0, (n / 2));
        String s2 = s.substring(n / 2);
        for (int i = 0; i < s1.length(); i++) {
            temp = s2.indexOf(s1.charAt(i));
            if (temp == -1) {
                count++;
            } else {
                s2 = s2.replaceFirst(Character.toString(s1.charAt(i)), "");
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int count = anagram("fdhlvosfpafhalll");
        System.out.println(count);
    }
}
