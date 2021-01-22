package com.leetcode;

import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class DetermineIfTwoStringsAreClose {

    //word1 = "cabbba", word2 = "abbccc"
    public static void main(String[] args) {

        new DetermineIfTwoStringsAreClose().closeStrings("cabbba", "abbccc");
    }

    public boolean closeStrings(String word1, String word2) {

        if (word1.length() != word2.length())
            return false;
        Map<Character, Long> word1Map = word1.chars().mapToObj(value -> (char) value).
                collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        Map<Character, Long> word2Map = word2.chars().mapToObj(value -> (char) value).
                collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        boolean isKeySetEquals = word1Map.keySet().equals(word2Map.keySet());
        if (!isKeySetEquals)
            return false;
        return word1Map.values().stream().sorted().collect(Collectors.toList()).
                equals(word2Map.values().stream().sorted().collect(Collectors.toList()));


    }


}
