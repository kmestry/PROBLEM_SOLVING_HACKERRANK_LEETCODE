package com.hackerrank.Strings;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class SherlockAndValidString {

    static int maxValue = 0;

    // Complete the isValid function below.
    static String isValid(String s) {

        String[] stringArray = s.split("");
        Map<String, Integer> charMap = new HashMap();

        for (int i = 0; i < stringArray.length; i++) {
            if (charMap.containsKey(stringArray[i])) {
                int count = charMap.get(stringArray[i]);
                charMap.put(stringArray[i], count + 1);
            } else {
                charMap.put(stringArray[i], 1);
            }

        }

        Map<Integer, Integer> integerIntegerMap = new HashMap<>();
        for (Integer i : charMap.values()) {
            if (integerIntegerMap.containsKey(i)) {
                int count = integerIntegerMap.get(i);
                integerIntegerMap.put(i, count + 1);
            } else {
                integerIntegerMap.put(i, 1);
            }
        }

        if (integerIntegerMap.size() == 2 && integerIntegerMap.containsKey(1) && integerIntegerMap.get(1).intValue() == 1) {
            return "YES";
        }

        integerIntegerMap.entrySet().stream().forEach(integerIntegerEntry -> {
            if (integerIntegerEntry.getValue().intValue() > maxValue) {
                maxValue = integerIntegerEntry.getKey().intValue();
            }
        });

        int actualcalulatedValue = 0;
        for (Integer sherlockInteger : charMap.values()) {
            if (Math.abs(maxValue - sherlockInteger) != 0) {
                actualcalulatedValue += Math.abs(maxValue - sherlockInteger);
            }
        }
        if (actualcalulatedValue > 1) {
            return "NO";
        } else {
            return "YES";
        }

    }

    public static void main(String[] args) {
    /*    //  isValid("abcdefghhgfedecba");
        String result = isValid("aaaabbcc");
        // String result = isValid("aabbccddeefghi");
        System.out.println("result = " + result);*/

        Scanner src = new Scanner(System.in);
        String input = src.nextLine();
        String result = isValid(input);
        System.out.println("result = " + result);
    }
}
