package com.geeksforgeeks.strings;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CheckIfStringIsSubsequenceOfOtherString {

    //TLE solution
    public static void main(String[] args) {
        CheckIfStringIsSubsequenceOfOtherString.isSubSequence("AXY", "ADXCPY");
    }

    public static boolean isSubSequence(String A, String B) {
        //code here
        Map<Character, List<Integer>> map = new HashMap<>();

        for (int i = 0; i < B.length(); i++) {

            char c = B.charAt(i);
            if (map.containsKey(c)) {
                List<Integer> indexList = map.get(c);
                indexList.add(i);
                map.put(c, indexList);
            } else {
                List<Integer> initialList = new ArrayList<>();
                initialList.add(i);
                map.put(c, initialList);
            }
        }

        int currIndex = -1;

        for (int i = 0; i < A.length(); i++) {
            char c = A.charAt(i);
            if (map.containsKey(c)) {
                List<Integer> iList = map.get(c);
                boolean foundIndex = false;
                for (Integer j : iList) {
                    if (j > currIndex) {
                        currIndex = j;
                        foundIndex = true;
                        break;
                    }
                }
                if (!foundIndex) {
                    return false;
                }
            } else {
                return false;
            }
        }
        return true;
    }
}
