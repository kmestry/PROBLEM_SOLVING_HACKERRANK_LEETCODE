package com.geeksforgeeks.recursion;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PossibleWordsFromPhoneDigits {

    static Map<Integer, String> map = new HashMap<>();

    static {
        map.put(2, "abc");
        map.put(3, "def");
        map.put(4, "ghi");
        map.put(5, "jkl");
        map.put(6, "mno");
        map.put(7, "pqrs");
        map.put(8, "tuv");
        map.put(9, "wxyz");
    }

    public static void main(String[] args) {

        PossibleWordsFromPhoneDigits.possibleWords(new int[]{2, 3, 4}, 3);
    }

    //Function to find list of all words possible by pressing given numbers.
    static ArrayList<String> possibleWords(int[] a, int N) {
        // your code here

        ArrayList<String> list = new ArrayList<>();
        helper("", list, a, 0);
        System.out.println("list = " + list);
        return list;

    }


    static void helper(String curr, List<String> list, int[] arr, int index) {

        if (curr.length() == arr.length) {
            list.add(curr);
            return;
        }


        String currString = map.get(arr[index]);

        for (int j = 0; j < currString.length(); j++) {
            helper(curr + currString.charAt(j), list, arr, index + 1);
        }


    }
}
