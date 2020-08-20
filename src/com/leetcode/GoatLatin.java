package com.leetcode;

import java.util.Arrays;
import java.util.List;

public class GoatLatin {


    static final List<String> vowelList;

    static {
        vowelList = Arrays.asList("a", "e", "i", "o", "u");
    }

    String goatLanguageAppender = "ma";
    String extraSuffix = "a";

    public static void main(String[] args) {

        String result = new GoatLatin().toGoatLatin("I speak Goat Latin");
        System.out.println("result = " + result);

    }

    public String toGoatLatin(String sentence) {

        String resultString = "";
        String[] words = sentence.split(" ");

        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            char firstCharacter = word.charAt(0);  // first char of word;
            String goatWord;
            if (vowelList.contains(String.valueOf(firstCharacter).toLowerCase())) {
                goatWord = word + goatLanguageAppender;
            } else {
                goatWord = word.substring(1) + firstCharacter + goatLanguageAppender;
            }

            resultString += goatWord + extraSuffix + " ";

            extraSuffix += "a";
        }

        return resultString.substring(0, resultString.length() - 1);

    }
}
