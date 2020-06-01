package com.hackerrank.Strings;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class AnagramIncorrect {

    private static final Scanner scanner = new Scanner(System.in);
    private static int value;

    // Complete the anagram function below.
    static int anagram(String s) {
        if (s.length() % 2 != 0) {
            return -1;
        }
        int middlePointOfString = s.length() / 2;
        String firstString = s.substring(0, middlePointOfString);
        String secondString = s.substring(middlePointOfString);

        String[] firstStringArray = firstString.split("");
        String[] secondStringArray = secondString.split("");

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
                    value += Math.abs(stringIntegerEntry.getValue() + stringIntegerEntry1.getValue());
                    stringIntegerEntry1.setValue(0);
                    stringIntegerEntry.setValue(0);
                }

            });
        });


        long firsMapSum = firstMap.entrySet().stream().filter(stringIntegerEntry -> stringIntegerEntry.getValue() > 0).mapToInt(value1 -> value1.getValue()).sum();

        long secondMapSum = secondMap.entrySet().stream().filter(stringIntegerEntry -> stringIntegerEntry.getValue() > 0).mapToInt(value1 -> value1.getValue()).sum();

        int totalCount = (int) (value + firsMapSum + secondMapSum);
        System.out.println("totalCount = " + totalCount / 2);
        return totalCount / 2;


    }

    public static void main(String[] args) throws IOException {
        anagram("mvdalvkiopaufl");

    }
}
