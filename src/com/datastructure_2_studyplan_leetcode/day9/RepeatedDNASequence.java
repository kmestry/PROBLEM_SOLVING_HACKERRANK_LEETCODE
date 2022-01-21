package com.datastructure_2_studyplan_leetcode.day9;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class RepeatedDNASequence {

    public static void main(String[] args) {
        RepeatedDNASequence repeatedDNASequence = new RepeatedDNASequence();
        repeatedDNASequence.findRepeatedDnaSequences("AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT");
    }

    public List<String> findRepeatedDnaSequences(String s) {

        Set<String> seen = new HashSet<>();
        Set<String> repeated = new HashSet<>();

        for (int i = 0; i < s.length(); i++) {
            if (i + 10 > s.length()) break;
            String str = s.substring(i, i + 10);


            if (!seen.add(str)) {
                repeated.add(str);
            }
        }

        return new ArrayList<>(repeated);
    }

}
