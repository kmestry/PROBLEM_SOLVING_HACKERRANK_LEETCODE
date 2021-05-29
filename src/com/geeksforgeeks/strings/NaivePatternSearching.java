package com.geeksforgeeks.strings;

import java.util.ArrayList;
import java.util.List;

public class NaivePatternSearching {
    public static void main(String[] args) {

        NaivePatternSearching naivePatternSearching = new NaivePatternSearching();
        // List<Integer> list = naivePatternSearching.naivePatternSearch("ABABABCD", "ABAB");
        //  List<Integer> list = naivePatternSearching.naivePatternSearch("ABCABCD", "ABCD");
        List<Integer> list = naivePatternSearching.naivePatternSearch("AAAAA", "AAA");
        System.out.println(list);
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    private List<Integer> naivePatternSearch(String s, String pattern) {
        // ABABABCD
        // ABAB

        int hashcode = pattern.hashCode();
        List<Integer> list = new ArrayList<>();
        int left = 0;
        int right = pattern.length();

        while (right <= s.length()) {
            String substring = s.substring(left, right);
            int hashcodeSubString = substring.hashCode();

            if (hashcode == hashcodeSubString) {
                list.add(left);
            }
            right++;
            left++;
        }
        return list;
    }
}
