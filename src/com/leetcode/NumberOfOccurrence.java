package com.leetcode;

import java.util.HashMap;
import java.util.Map;

public class NumberOfOccurrence {
    // "cloud"
    // String s = "Cloud tech is everywhere now its everywhere
    //cloud



    private static void getOccurrenceOfWord(String input) {
        Map<String, Integer> map = new HashMap<>();

        String[] arrayOfWords = input.split(" ");

        for (int i = 0; i < arrayOfWords.length; i++) {

            String word = arrayOfWords[i];

            if (map.containsKey(word)) {
                map.put(word, map.get(word) + 1);
            } else {
                map.put(word, 1);
            }

        }

        System.out.println("Count of words is " + map);


    }

    public static void main(String[] args) {

        NumberOfOccurrence.getOccurrenceOfWord("Cloud tech is everywhere now its everywhere");
    }
}
