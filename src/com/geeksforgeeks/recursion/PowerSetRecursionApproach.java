package com.geeksforgeeks.recursion;

import java.util.ArrayList;

public class PowerSetRecursionApproach {

    public static void main(String[] args) {
        PowerSetRecursionApproach.powerSet("abc");
    }

    static ArrayList<String> powerSet(String s) {
        // add your code here

        ArrayList<String> list = new ArrayList<>();
        helper(s, "", 0, list);
        System.out.println("list = " + list);
        return list;

    }


    static void helper(String s, String curr, int index, ArrayList<String> list) {

        if (index == s.length()) {
            list.add(curr);
            return;
        }

        helper(s, curr, index + 1, list);
        helper(s, curr + s.charAt(index), index + 1, list);
    }
}
