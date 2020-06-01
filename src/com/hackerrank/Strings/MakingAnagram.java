package com.hackerrank.Strings;

import java.util.HashMap;
import java.util.Map;

public class MakingAnagram {

    private static int value;


    static int makingAnagrams(String s1, String s2) {
        String[] firstStringArray = s1.split("");
        String[] secondStringArray = s2.split("");

        Map<String, Integer> firstMap = new HashMap();
        Map<String, Integer> secondMap = new HashMap();

        for (int i = 0; i < firstStringArray.length; i++) {
            if (firstMap.containsKey(firstStringArray[i])) {
                int counter = firstMap.get(firstStringArray[i]);
                firstMap.put(firstStringArray[i], counter + 1);

            } else {
                firstMap.put(firstStringArray[i], 1);
            }
        }

        for (int i = 0; i < secondStringArray.length; i++) {
            if (secondMap.containsKey(secondStringArray[i])) {
                int counter = secondMap.get(secondStringArray[i]);
                secondMap.put(secondStringArray[i], counter + 1);

            } else {
                secondMap.put(secondStringArray[i], 1);
            }
        }


        firstMap.entrySet().stream().forEach(stringIntegerEntry -> {
            secondMap.entrySet().stream().forEach(stringIntegerEntry1 -> {
                if (stringIntegerEntry.getKey().equals(stringIntegerEntry1.getKey())) {
                    value += Math.abs(stringIntegerEntry.getValue() - stringIntegerEntry1.getValue());
                    stringIntegerEntry1.setValue(0);
                    stringIntegerEntry.setValue(0);
                }

            });
        });


        long firsMapSum = firstMap.entrySet().stream().filter(stringIntegerEntry -> stringIntegerEntry.getValue() > 0).mapToInt(value1 -> value1.getValue()).sum();

        long secondMapSum = secondMap.entrySet().stream().filter(stringIntegerEntry -> stringIntegerEntry.getValue() > 0).mapToInt(value1 -> value1.getValue()).sum();

        int totalCount = (int) (value + firsMapSum + secondMapSum);
        System.out.println("totalCount = " + totalCount);
        return totalCount;
    }

    public static void main(String[] args) {
        // makingAnagrams("cde","abc");
        makingAnagrams("fcrxzwscanmligyxyvym", "jxwtrhvujlmrpdoqbisbwhmgpmeoke");

    }
}

