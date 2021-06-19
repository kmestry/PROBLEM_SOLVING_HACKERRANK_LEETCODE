package com.hackerrank.interview_companies_logic;

import java.util.HashMap;
import java.util.Map;

//MCMXC
public class RomanToInteger {

    private static final Map<Character,
            Integer> romanCharMap = new HashMap<>() {{
        put('I', 1);
        put('V', 5);
        put('X', 10);
        put('L', 50);
        put('C', 100);
        put('D', 500);
        put('M', 1000);
    }};

    public static void main(String[] args) {
        int result = RomanToInteger.decode("MMVIII");
        System.out.println(result);
    }

    public static Integer decode(String roman) {

        int number = romanCharMap.get(roman.charAt(roman.length() - 1));

        for (int i = roman.length() - 2; i >= 0; i--) {
            int currValue = romanCharMap.get(roman.charAt(i));
            int nextValue = romanCharMap.get(roman.charAt(i + 1));
            if (currValue >= nextValue) {
                number += currValue;
            } else {
                number -= currValue;
            }
        }

        return number;
    }
}
